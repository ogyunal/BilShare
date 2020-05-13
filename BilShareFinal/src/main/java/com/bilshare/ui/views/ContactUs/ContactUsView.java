package com.bilshare.ui.views.ContactUs;

import com.bilshare.backend.data.Category;
import com.bilshare.backend.data.Type;
import com.bilshare.backend.entity.Product;
import com.bilshare.backend.service.ProductService;
import com.bilshare.ui.MainLayout;
import com.bilshare.ui.views.list.ProductForm;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
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
public class ContactUsView extends FormLayout {

    TextField userName;
    EmailField email;
    TextArea problems;
    ComboBox<String> category;

    Button submit = new Button("Submit");
    Button clean = new Button("Clean");


    public ContactUsView()
    {
    userName= new TextField("Your Username");
    email = new EmailField("Your Email");
    problems = new TextArea("Any Problems?");
    category = new ComboBox<>("Problem Category");

    // Category CheckBox
    category.setItems("Adding advert", "Technical problems", "Inappropriate content", "Purchasing Material", "Viewing Advert","Other");


    // seller username
    userName.setPlaceholder("Type your username here...");
    email.setPlaceholder("Type your email here...");

    add(userName,email,category,problems,submit,clean);
        createButtonsLayout();
    }


    public void createButtonsLayout() {
        submit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        clean.addThemeVariants(ButtonVariant.LUMO_ERROR);

        submit.addClickShortcut(Key.ENTER);

        submit.addClickListener(click -> {
            //validateAndSave();
            cleanForm();
        });
        clean.addClickListener(buttonClickEvent -> cleanForm());

        //binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.add(submit, clean);
        buttonLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        add(buttonLayout);

    }

    //private void validateAndSave() {

    //}

    private void cleanForm() {
        userName.setValue("");
        email.setValue("");
        problems.setValue("");
        category.setValue("");
    }

    public void readOnly(boolean readOnly) {
        email.setReadOnly(readOnly);
        userName.setReadOnly(readOnly);
        category.setReadOnly(readOnly);
        problems.setReadOnly(readOnly);
    }
}
