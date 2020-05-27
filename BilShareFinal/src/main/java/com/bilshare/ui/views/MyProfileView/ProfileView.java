package com.bilshare.ui.views.MyProfileView;

import com.bilshare.backend.service.ProductService;
import com.bilshare.backend.service.UserService;
import com.bilshare.ui.MainLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ProfileView class enables user to show its profile view
 * @author BilShare
 * @version 1.0
 */
@Route(value = "myProfileView", layout = MainLayout.class)
@PageTitle("My Profile | BilShare")
public class ProfileView extends HorizontalLayout
{
    //properties
    public static final String VIEW_NAME = "My Profile";
    private ProfileListView currentAdverts ;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    //constructor
    public ProfileView(ProductService productService, UserService userService)
    {
        this.productService = productService;
        this.userService = userService;
        buildUI();
    }
    /**
     *buildUI() adding profile informations and adverts of the profile to the layout
     */
    private void buildUI()
    {
        VerticalLayout profileInfo = new VerticalLayout();
        profileInfo.setWidth("1200");
        add(profileInfo);
        VerticalLayout adverts = new VerticalLayout();
        adverts.add(new Label("Current Adverts"));
        currentAdverts = new ProfileListView(productService);
        adverts.add(currentAdverts);
        add(adverts);
        setSizeFull();
    }
}