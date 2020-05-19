package com.bilshare.ui.views.About;

import com.bilshare.ui.MainLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * About view class
 * @author BilShare
 * @version 1.0
 */
@Route(value = "about", layout = MainLayout.class)
@PageTitle("About | BilShare")
public class AboutView extends VerticalLayout {

    // properties
    private Label info;
    private VerticalLayout aboutInfo;

    // constructor
    public AboutView() {
        // initializing the properties
        aboutInfo = new VerticalLayout();
        info = new Label();

        // setting the info text
        info.setText("\nBilshare is a web app that enables college students to sell and buy second hand course materials.\n " +
                "\nThis app is created by Oğulcan Ünal,Yağmur Eryılmaz Elif Çenesiz, Berk Türkçapar, Melih Obut and İdil Yılmaz.\n" +
                "\nCONTACT US AT: contact@bil-share.com");

        // adding label to layout
        aboutInfo.add(info);

        // adding layout to view
        add(aboutInfo );
    }
}