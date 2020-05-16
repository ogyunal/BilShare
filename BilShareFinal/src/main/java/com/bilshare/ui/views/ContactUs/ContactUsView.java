
package com.bilshare.ui.views.ContactUs;


import com.bilshare.backend.data.Category;
import com.bilshare.backend.data.Type;
import com.bilshare.backend.entity.Product;
import com.bilshare.backend.service.ProductService;
import com.bilshare.ui.MainLayout;
import com.bilshare.ui.views.list.ProductForm;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;



@Route(value = "contactUsView", layout = MainLayout.class)
@PageTitle("Contact Us")
public class ContactUsView extends VerticalLayout {


    public ContactUsView()
    {
        initView();
        IFrame iFrame = new IFrame();
        iFrame.setSrc("https://form.jotform.com/201366581719965");
        iFrame.setWidth("100%");
        iFrame.setHeight("1100px");
        add(iFrame);
    }

    private void initView() {
        setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    }

}

