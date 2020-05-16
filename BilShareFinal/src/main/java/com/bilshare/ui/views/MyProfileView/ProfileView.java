package com.bilshare.ui.views.MyProfileView;

import com.bilshare.backend.service.ProductService;
import com.bilshare.ui.MainLayout;
import com.bilshare.ui.views.list.ListView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "myProfileView", layout = MainLayout.class)
@PageTitle("My Profile")
public class ProfileView extends HorizontalLayout
{
    @Autowired
    private ProductService productService;
    public static final String VIEW_NAME = "My Profile";
    private ProfileListView currentAdverts ;
    private ListView soldMaterials ;
    private  ListView purchasedMaterials ;
    private Label firstName = new Label ("Name");
    private Label lastName= new Label ("Surname");
    private Label department= new Label ("Department");

    public ProfileView(ProductService productService)
    {
        this.productService=productService;
        buildUI();
    }

    private void buildUI()
    {

        VerticalLayout profileInfo = new VerticalLayout();
        profileInfo.add(firstName);
        profileInfo.add(lastName);
        profileInfo.add(department);
        profileInfo.setWidth("1200");
        //profileInfo.add(photo);
        add(profileInfo);
        VerticalLayout adverts = new VerticalLayout();
        adverts.add(new Label("Current Adverts"));
        currentAdverts = new ProfileListView(productService);
        adverts.add(currentAdverts);
        add(adverts);
        setSizeFull();






    }

}
