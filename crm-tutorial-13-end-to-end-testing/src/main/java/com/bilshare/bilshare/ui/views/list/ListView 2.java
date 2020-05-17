package com.bilshare.bilshare.ui.views.list;

import com.bilshare.bilshare.backend.entity.Item;
import com.bilshare.bilshare.backend.entity.Product;
import com.bilshare.bilshare.backend.service.ProductService;
import com.bilshare.bilshare.backend.service.ItemService;
import com.bilshare.bilshare.ui.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Route(value = "", layout = MainLayout.class)
@PageTitle("Contacts | Vaadin CRM")
public class ListView extends VerticalLayout {

    ContactForm form;
    Grid<Item> grid = new Grid<>(Item.class);
    TextField filterText = new TextField();

    ItemService itemService;

    public ListView(ItemService itemService,
                    ProductService productService) {
        this.itemService = itemService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();


        form = new ContactForm(productService.findAll());
        form.addListener(ContactForm.SaveEvent.class, this::saveContact);
        form.addListener(ContactForm.DeleteEvent.class, this::deleteContact);
        form.addListener(ContactForm.CloseEvent.class, e -> closeEditor());

        Div content = new Div(grid, form);
        content.addClassName("content");
        content.setSizeFull();

        add(getToolBar(), content);
        updateList();
        closeEditor();
    }

    private void deleteContact(ContactForm.DeleteEvent evt) {
        itemService.delete(evt.getItem());
        updateList();
        closeEditor();
    }

    private void saveContact(ContactForm.SaveEvent evt) {
        itemService.save(evt.getItem());
        updateList();
        closeEditor();
    }

    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addContactButton = new Button("Add contact", click -> addContact());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void addContact() {
        grid.asSingleSelect().clear();
        editContact(new Item());
    }

    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.removeColumnByKey("company");
        grid.setColumns("firstName", "lastName", "email", "status");
        grid.addColumn(contact -> {
           Product product = contact.getProduct();
           return product == null ? "-" : product.getName();
        }).setHeader("Company");

        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(evt -> editContact(evt.getValue()));
    }

    private void editContact(Item item) {
        if (item == null) {
            closeEditor();
        } else {
            form.setContact(item);
            form.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        form.setContact(null);
        form.setVisible(false);
        removeClassName("editing");
    }

    private void updateList() {
        grid.setItems(itemService.findAll(filterText.getValue()));
    }

}
