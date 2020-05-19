package com.bilshare.ui.views.AddAdvert;

import com.bilshare.backend.service.ProductService;
import com.bilshare.ui.MainLayout;
import com.bilshare.ui.views.list.ProductForm;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AddAdvert view class which enables users to add new adverts to the inventory
 * @author BilShare
 * @version 1.0
 */

@Route(value = "addAdvert", layout = MainLayout.class)
@PageTitle("Add Advert | BilShare")
public class AddAdvertView extends VerticalLayout {

    // properties
    @Autowired
    ProductService productService;
    private ProductForm form;
    private H3 header;

    // constructor
    public AddAdvertView (ProductService productService){
        // initializing
        this.productService = productService;
        form = new ProductForm(productService);
        header = new H3("New Advert Form");

        // creating buttons
        form.createButtonsLayout();

        // adding the components
        add(header, form);

        // setting alignment to center
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
}
