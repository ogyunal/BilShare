package com.bilshare.bilshare.bookstore.ui.about;

import com.bilshare.bilshare.bookstore.ui.MainLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "About", layout = MainLayout.class)
@PageTitle("About")
public class AboutView extends HorizontalLayout {

    public static final String VIEW_NAME = "About";

    public AboutView() {
        add(VaadinIcon.INFO_CIRCLE.create());
        add(new Span(" This application is built by  Oğulcan Ünal, Yağmur Eryılmaz, İdil Yılmaz, Berk Türkçapar, Elif Çenesiz, Melih Obut. "));
                 //Version.getFullVersion() + "."));
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

    }
}
