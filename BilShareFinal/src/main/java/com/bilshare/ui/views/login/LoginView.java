package com.bilshare.ui.views.login;


import com.bilshare.backend.CurrentUser;
import com.bilshare.backend.entity.User;
import com.bilshare.backend.service.UserService;
import com.bilshare.ui.views.signup.SignUpForm;
import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;


import java.util.Collections;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.springframework.beans.factory.annotation.Autowired;


@Route("login")
@PageTitle("Login | BilShare")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    SignUpForm form;
    LoginForm login = new LoginForm();

    @Autowired
    UserService userService;

    final String resolvedImage = VaadinService.getCurrent().resolveResource(
            "https://imagehost.imageupload.net/2020/05/13/icon.png", VaadinSession.getCurrent().getBrowser());


    final Image image = new Image(resolvedImage, "");
    public static Dialog signUpDialog = new Dialog();

    Button signUpButton = new Button("Don't Have an Account?");

    public LoginView(UserService userService) {
        this.userService = userService;
        addClassName("login-view");
        setSizeFull();

        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        login.setAction("login");
        login.setForgotPasswordButtonVisible(true);
        signUpButton.addClickListener(buttonClickEvent -> signUpDialog.open());


        form = new SignUpForm(userService);
        signUpDialog.add(form);
        signUpDialog.setWidth("40");
        signUpDialog.setHeight("100");

        add(
                image,
                login, signUpButton

        );

        login.addLoginListener(e-> {
            String username = e.getUsername();
            String password = e.getPassword();
            CurrentUser.setUser(username,password);
        });


    }

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

    public  User getCurrentUser()
    {
        var lambdaContext = new Object() {
            String username;
            String password;
        };
        login.addLoginListener(e-> {
            lambdaContext.username = e.getUsername();
            lambdaContext.password = e.getPassword();
        });
        return userService.findByLogin(lambdaContext.username,lambdaContext.password);
    }
}
