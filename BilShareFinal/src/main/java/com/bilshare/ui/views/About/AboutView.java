package com.bilshare.ui.views.About;

import com.bilshare.ui.MainLayout;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;

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
    Anchor ogulcanLinkedin = new Anchor();
    Anchor elifLinkedin = new Anchor();
    Anchor berkLinkedin = new Anchor();
    Anchor yagmurLinkedin = new Anchor();
    Anchor idilLinkedin = new Anchor();
    Anchor melihLinkedin = new Anchor();

    // Linkedin Image For The Anchor
    final String resolvedImage = VaadinService.getCurrent().resolveResource(
            "https://i.pinimg.com/236x/c0/44/d1/c044d19025e6939e49af34610e2694d7.jpg", VaadinSession.getCurrent().getBrowser());
    final Image linkedinImage = new Image(resolvedImage, "");

    // constructor
    public AboutView() {
        // initializing the properties
        aboutInfo = new VerticalLayout();
        info = new Label();

        // setting the info text
        info.setText("\nBilshare is a web app that enables college students to sell and buy second hand course materials.\n " +
                "\nThis app is created by Oğulcan Ünal,Yağmur Eryılmaz Elif Çenesiz, Berk Türkçapar, Melih Obut and İdil Yılmaz.\n" +
                "\n                     Contact us at: contact@bil-share.com");

        //setting up the anchors
        ogulcanLinkedin.setText("Oğulcan Ünal");
        ogulcanLinkedin.setHref("https://www.linkedin.com/in/oğulcan-ünal-052625189/?originalSubdomain=tr");
        elifLinkedin.setText("Elif Çenesiz");
        elifLinkedin.setHref("https://www.linkedin.com/in/gamze-elif-çenesiz-765a0b1a3/?originalSubdomain=tr");
        berkLinkedin.setText("Berk Türkçapar");
        berkLinkedin.setHref("https://www.linkedin.com/in/mehmet-berk-türkçapar-104300196/?originalSubdomain=tr");
        yagmurLinkedin.setText("Yağmur Eryılmaz");
        yagmurLinkedin.setHref("https://www.linkedin.com/");
        idilLinkedin.setText("İdil Yılmaz");
        idilLinkedin.setHref("https://www.linkedin.com/in/idil-yılmaz-40744a14b/?originalSubdomain=tr");
        melihLinkedin.setText("Melih Obut");
        melihLinkedin.setHref("https://www.linkedin.com/in/melih-obut-06506b105/?originalSubdomain=tr");

        // adding label to layout
        aboutInfo.add(info, linkedinImage,
                ogulcanLinkedin, elifLinkedin, yagmurLinkedin, berkLinkedin, idilLinkedin, melihLinkedin);

        // adding layout to view
        add(aboutInfo );
    }
}