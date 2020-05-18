package com.bilshare.ui.views.MyProfileView;

import com.bilshare.backend.CurrentUser;
import com.bilshare.backend.service.ProductService;
import com.bilshare.backend.service.UserService;
import com.bilshare.ui.MainLayout;
import com.bilshare.ui.views.list.ListView;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "myProfileView", layout = MainLayout.class)
@PageTitle("My Profile | BilShare")
public class ProfileView extends HorizontalLayout
{
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    public static final String VIEW_NAME = "My Profile";
    private ProfileListView currentAdverts ;
    private ListView soldMaterials ;
    private  ListView purchasedMaterials ;
    private Label firstName ;
    private Label lastName ;

    public ProfileView(ProductService productService, UserService userService)
    {
        this.productService = productService;
        this.userService = userService;

        buildUI();
    }

    private void buildUI()
    {
        firstName = new Label ((userService.findByLogin(CurrentUser.getUser().getUsername(), CurrentUser.getUser().getPassword())).getFirstName());

        lastName= new Label ("Surname");
        VerticalLayout profileInfo = new VerticalLayout();
        profileInfo.add(firstName);
        profileInfo.add(lastName);

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
