package com.bilshare.ui.views.ContactUs;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.bilshare.ui.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.ui.LoadMode;

import javax.annotation.Resource;


@Tag("div")
@HtmlImport("./src/contactus.html")
@PageTitle("Contact Us | Bilshare")
@Route(value = "contactus", layout = MainLayout.class)
@Resource
public class ContactUsView extends VerticalLayout {

    public ContactUsView() {

        UI.getCurrent().getPage().addHtmlImport(
                "./src/contactus.html", LoadMode.EAGER);


    }

}