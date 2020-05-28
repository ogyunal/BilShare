
package com.bilshare.ui.views.contactUs;

import com.bilshare.ui.MainLayout;
import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Contact Us View class which enables users to contact with the BilShare
 * @author BilShare
 * @version 1.0
 */

@Route(value = "contactUsView", layout = MainLayout.class)
@PageTitle("Contact Us | BilShare")
public class ContactUsView extends VerticalLayout {


    //constructor
    public ContactUsView()
    {
        initView();
        //creating an iframe
        IFrame iFrame = new IFrame();
        // using jotform
        iFrame.setSrc("https://form.jotform.com/201366581719965");
        iFrame.setWidth("100%");
        iFrame.setHeight("1100px");
        add(iFrame);
    }

    /**
     * initView() setting alignment
     */
    private void initView() {
        setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    }

}

