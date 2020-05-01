package com.bilshare.bilshare.bookstore.ui.signup.ui;

import com.bilshare.bilshare.bookstore.backend.data.Book;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.stereotype.Component;

@Component
@Route("BookList")
@PageTitle("BookList | Vaadin CRM")
public class BookListView extends VerticalLayout {

    Grid<Book> grid = new Grid<>(Book.class);
    TextField filterText = new TextField();

    public BookListView() {

        addClassName("list-view");
        setSizeFull();
        configureGrid();

        Div content = new Div(grid);
        content.addClassName("content");
        content.setSizeFull();

        add(getToolBar(), content);
        //updateList();
        //closeEditor();
    }

    //private void deleteContact(ContactForm.DeleteEvent evt) {
    //contactService.delete(evt.getContact());
    //updateList();
    //closeEditor();

    private void configureGrid() {
        grid.setSizeFull();
        grid.setColumns("photo", "name", "author", "relatedCourse", "price");

        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        //filterText.addValueChangeListener(e -> updateList());

        HorizontalLayout toolbar = new HorizontalLayout(filterText);
        toolbar.addClassName("toolbar");
        return toolbar;
    }
}
