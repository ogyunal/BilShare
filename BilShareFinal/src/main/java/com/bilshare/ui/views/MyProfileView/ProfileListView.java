package com.bilshare.ui.views.MyProfileView;

import com.bilshare.backend.CurrentUser;
import com.bilshare.backend.entity.Product;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.bilshare.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProfileListView class creating grids and dialog to show profiles
 * @author BilShare
 * @version 1.0
 */
@Component
@RestController
public class ProfileListView extends VerticalLayout {
    //properties
    ProfileProductForm form;
    Grid<Product> grid = new Grid<>(Product.class);
    TextField filterText = new TextField();
    private Dialog showProdDialog = new Dialog();

    //constructor
    @Autowired
    ProductService productService;
    public ProfileListView(ProductService productService) {
        // initializing the properties
        this.productService = productService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        //creating forms
        form = new ProfileProductForm(productService);
        showProdDialog.add(form);
        //setting width and height
        showProdDialog.setWidth("40");
        showProdDialog.setHeight("100");
        showProdDialog.close();

        //adding toolbar , grid and dialog to layout
        add(getToolBar(), grid, showProdDialog);
        updateList();

    }
    //program code
    /**
     *getToolBar() filter users by their name
     *@return toolbar
     */
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

    /**
     * configureGrid() arrange grid, set columns and add action to grids.
     */
    private void configureGrid() {
        grid.addClassName("product-grid");
        grid.setSizeFull();
        grid.removeColumnByKey("category");
        grid.setColumns("image", "seller", "productName", "price", "type", "category");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.asSingleSelect().addValueChangeListener(evt -> showProduct(evt.getValue()));
    }

    /**
     *closeEditor() close the dialog form
     */
    private void closeEditor() {
        form.setProduct(null);
        showProdDialog.close();
    }

    /**
     *updateList() after filtering shows the user
     */
    private void updateList() {
        grid.setItems(productService.findBySeller(CurrentUser.getUser().getUsername(),filterText.getValue()));
    }
    /**
     *showProduct() shows product in the dialog
     *@param product Product
     */
    public void showProduct(Product product) {
        form.setProduct(product);
        showProdDialog.open();
    }

}
