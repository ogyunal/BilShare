package com.bilshare.bilshare.bookstore.ui.login;

import com.bilshare.bilshare.bookstore.authentication.AccessControl;
import com.bilshare.bilshare.bookstore.authentication.AccessControlFactory;
import com.bilshare.bilshare.bookstore.ui.signup.data.UserDetailsService;
import com.bilshare.bilshare.bookstore.ui.signup.ui.SignupView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UI content when the user is not logged in yet.
 */
@Route("Login")
@PageTitle("Login")
@CssImport("./styles/shared-styles.css")
public class LoginView extends FlexLayout {

    private AccessControl accessControl;
    private UserDetailsService uds = new UserDetailsService();
    private SignupView signupView = new SignupView(uds);
    private Dialog signupPopup;
    private Button signup = new Button("Sign-up");

    public LoginView() {
        accessControl = AccessControlFactory.getInstance().createAccessControl();
        buildUI();
    }

    private void buildUI() {
        setSizeFull();
        setClassName("login-screen");

        // login form, centered in the available part of the screen
        LoginForm loginForm = new LoginForm();
        loginForm.addLoginListener(this::login);
        loginForm.addForgotPasswordListener(
                event -> Notification.show("Hint: same as username"));

        // layout to center login form when there is sufficient screen space

        FlexLayout centeringLayout = new FlexLayout();
        centeringLayout.setSizeFull();
        centeringLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        centeringLayout.setAlignItems(Alignment.CENTER);
        signupPopup  = new Dialog();
        signupPopup.add(signupView);
        centeringLayout.add(loginForm);
        //signupPopup.setVisible(false);
        //signupPopup.setAlign(QuickPopup.Align.TOP_LEFT);

        // information text about logging in
        add(signupPopup);
        Component loginInformation = buildLoginInformation();
        add(loginInformation);
        add(centeringLayout);
    }

    private Component buildLoginInformation() {
        signup.addClickListener(buttonClickEvent -> signupPopup.open());
        signup.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        VerticalLayout loginInformation = new VerticalLayout();
        loginInformation.setClassName("login-information");

        H1 loginInfoHeader = new H1("Welcome to BilShare");
        loginInfoHeader.setWidth("100%");
        Span loginInfoText = new Span(
                "Log in as \"admin\" to have full access. Log in with any " +
                        "other username to have read-only access. For all " +
                        "users, the password is same as the username. If you don't" +
                        "have an account you can sign-up here. (Click on the button)");
        loginInfoText.setWidth("100%");
        loginInformation.add(loginInfoHeader);
        loginInformation.add(loginInfoText);
        loginInformation.add(signup);

        return loginInformation;
    }

    private void login(LoginForm.LoginEvent event) {
        if (accessControl.signIn(event.getUsername(), event.getPassword())) {
            getUI().get().navigate("");
        } else {
            event.getSource().setError(true);
        }
    }
}
