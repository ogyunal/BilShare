package com.bilshare.ui.views.MyProfileView;
import com.bilshare.backend.CurrentUser;
import com.bilshare.backend.entity.Product;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.bilshare.backend.service.ProductService;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class ProfileListView extends VerticalLayout {

    ProfileProductForm form;
    Grid<Product> grid = new Grid<>(Product.class);
    TextField filterText = new TextField();

    private Dialog showProdDialog = new Dialog();


    @Autowired
    ProductService productService;

    public ProfileListView(ProductService productService) {
        this.productService = productService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        form = new ProfileProductForm(productService);

        showProdDialog.add(form);
        showProdDialog.setWidth("40");
        showProdDialog.setHeight("100");
        showProdDialog.close();

        add(getToolBar(), grid, showProdDialog);
        updateList();
        //closeEditor();
    }

    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Filter by name...");

        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());
        setSizeFull();

        HorizontalLayout toolbar = new HorizontalLayout(filterText);//, addProduct);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configureGrid() {
        grid.addClassName("product-grid");
        grid.setSizeFull();
        grid.removeColumnByKey("category");
        grid.setColumns("image", "seller", "productName", "price", "type", "category");

        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(evt -> showProduct(evt.getValue()));
    }


    private void closeEditor() {
        form.setProduct(null);
        //form.setVisible(false);
        //removeClassName("editing");
        showProdDialog.close();
    }

    private void updateList() {
        grid.setItems(productService.findBySeller(CurrentUser.getUser().getUsername(),filterText.getValue()));
        form.update.addClickListener(evt-> showProdDialog.close());
        form.update.addClickListener(evt-> UI.getCurrent().getPage().reload());
        form.delete.addClickListener(evt-> UI.getCurrent().getPage().reload());

    }

    public void showProduct(Product product) {
        form.setProduct(product);
        //form.setVisible(true);
        showProdDialog.open();
    }

}
