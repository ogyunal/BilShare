package com.bilshare.ui.views.AddAdvert;

import com.bilshare.backend.service.ProductService;
import com.bilshare.ui.MainLayout;
import com.bilshare.ui.views.list.ProductForm;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "addAdvert", layout = MainLayout.class)
public class AddAdvertView extends VerticalLayout {

    @Autowired
    ProductService productService;

    private ProductForm form;
    private H3 header;


    public AddAdvertView (ProductService productService){
        this.productService = productService;
        form = new ProductForm(productService);
        form.createButtonsLayout();


        header = new H3("New Advert Form");

        add(header, form);
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }

    private void showSuccess() {
        Notification notification = Notification.show("Your Advert Has Been Created ");
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        UI.getCurrent().navigate("");
    }
}
