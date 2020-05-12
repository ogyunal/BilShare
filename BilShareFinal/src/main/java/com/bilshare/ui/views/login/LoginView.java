package com.bilshare.ui.views.login;


import com.bilshare.backend.service.ProductService;
import com.bilshare.backend.service.UserService;
import com.bilshare.ui.views.list.ProductForm;
import com.bilshare.ui.views.signup.SignUpForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;

@Route("login")
@PageTitle("Login | BilShare")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    SignUpForm form;
    LoginForm login = new LoginForm();

    @Autowired
    UserService userService;

    final String resolvedImage = VaadinService.getCurrent().resolveResource(
            "icons/bilShareLogo.png", VaadinSession.getCurrent().getBrowser());


    final Image image = new Image(resolvedImage, "");
    private Dialog signUpDialog = new Dialog();

    Button signUpButton = new Button("Don't Have an Account?");

    public LoginView() {
        addClassName("login-view");
        setSizeFull();

        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        login.setAction("login");
        login.setForgotPasswordButtonVisible(false);

        signUpButton.addClickListener(buttonClickEvent -> signUpDialog.open());


        form = new SignUpForm(userService);
        signUpDialog.add(form);
        signUpDialog.setWidth("40");
        signUpDialog.setHeight("100");

        add(
                image,
                login, signUpButton

        );

    }

    //private void saveUser(SignUpForm.SaveEvent evt) {
    //  userService.save(evt.getUser());
    //}


    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(!beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .getOrDefault("error", Collections.emptyList())
                .isEmpty()) {
            login.setError(true);
        }
    }
}
