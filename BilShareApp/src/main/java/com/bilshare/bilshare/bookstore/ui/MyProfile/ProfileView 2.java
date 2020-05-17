package com.bilshare.bilshare.bookstore.ui.MyProfile;

import com.bilshare.bilshare.bookstore.ui.MainLayout;
import com.bilshare.bilshare.bookstore.ui.signup.data.AvatarImage;
import com.bilshare.bilshare.bookstore.ui.signup.ui.BookListView;
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
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "myProfile", layout = MainLayout.class)
@PageTitle("My Profile")
public class ProfileView extends FlexLayout
{
    public static final String VIEW_NAME = "My Profile";
    private BookListView currentAdverts ;
    private BookListView soldMaterials ;
    private BookListView purchasedMaterials ;
    private Label firstName = new Label ("Name");
    private Label lastName= new Label ("Surname");
    private Label department= new Label ("Department");
    private AvatarImage photo=null;

    public ProfileView()
    {
        buildUI();
    }

    private void buildUI()
    {

        VerticalLayout profileInfo = new VerticalLayout();
        profileInfo.add(firstName);
        profileInfo.add(lastName);
        profileInfo.add(department);
        //profileInfo.add(photo);
        Accordion accordion = new Accordion();
        currentAdverts = new BookListView();
        accordion.add("My Current Adverts", currentAdverts);
        profileInfo.add(accordion);
        setSizeFull();
        add(profileInfo);
        accordion.setWidthFull();


    }

}
