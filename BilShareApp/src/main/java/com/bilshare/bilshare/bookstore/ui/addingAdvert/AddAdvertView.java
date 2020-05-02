package com.bilshare.bilshare.bookstore.ui.addingAdvert;

import com.bilshare.bilshare.bookstore.ui.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "addAdvert", layout = MainLayout.class)
@PageTitle("Add an Advert")
public class AddAdvertView extends VerticalLayout {
    public static final String VIEW_NAME = "Add an Advert";
    private Button bookButton =  new Button("Add a Book");
    private Button notesButton = new Button("Add a Lecture Note");
    //private Image logo = new Image();
    H3 heading = new H3("What kind of advert would you like to add?");

    HorizontalLayout buttonLayout = new HorizontalLayout();

    public AddAdvertView() {
        buildUI();
    }
    public void buildUI(){
        add(heading);

        bookButton.addThemeVariants(ButtonVariant.LUMO_LARGE);
        notesButton.addThemeVariants(ButtonVariant.LUMO_LARGE);
        bookButton.setIcon(VaadinIcon.BOOK.create());
        notesButton.setIcon(VaadinIcon.NOTEBOOK.create());

        buttonLayout.add(bookButton);
        buttonLayout.add(notesButton);

        buttonLayout.setAlignItems(Alignment.CENTER);

        add(buttonLayout);
        add(new Span(" You can always add new adverts here." +
                " After adding them you can manage them in \"My Profile\" "));
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
        setSizeFull();
    }

}
