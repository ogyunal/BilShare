package com.bilshare.ui.views.signup;


import com.bilshare.backend.entity.Product;
import com.bilshare.backend.entity.User;
import com.bilshare.backend.service.UserService;
import com.bilshare.backend.data.AvatarImage;
import com.bilshare.ui.views.list.ProductForm;
import com.bilshare.ui.views.signup.AvatarField;
import com.bilshare.ui.views.login.LoginView;


import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.*;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.spring.annotation.UIScope;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;


public class SignUpForm extends VerticalLayout {

    @Autowired
    private UserService userService;

    private PasswordField passwordField1 = new PasswordField("Password");
    private PasswordField passwordField2 = new PasswordField("Password Again");

    private BeanValidationBinder<User> binder;

    private H3 title = new H3("BilShare Sign-up Form");

    private TextField firstnameField = new TextField("First Name");
    private TextField lastnameField = new TextField("Last Name");
    private TextField usernameField = new TextField("Username");

    private AvatarField avatarField = new AvatarField("Select Avatar image");
    private EmailField emailField = new EmailField("Email");

    /**
     * Flag for disabling first run for password validation
     */
    private boolean enablePasswordValidation;

    /**
     * We use Spring to inject the backend into our view
     */
    public SignUpForm(UserService userService) {

        this.userService = userService;

        Span errorMessage = new Span();

        Button submitButton = new Button("Join BilShare");
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // Create a FormLayout with all our components.
        FormLayout formLayout = new FormLayout(title, firstnameField, lastnameField, usernameField, passwordField1, passwordField2,
                emailField,
                avatarField,
                errorMessage, submitButton);

        // Restrict maximum width and center on page
        formLayout.setMaxWidth("500px");
        formLayout.getStyle().set("margin", "0 auto");

        // Allow the form layout to be responsive. On device widths 0-490px we have one
        // column, then we have two. Field labels are always on top of the fields.
        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1, FormLayout.ResponsiveStep.LabelsPosition.TOP),
                new FormLayout.ResponsiveStep("490px", 2, FormLayout.ResponsiveStep.LabelsPosition.TOP));

        // These components take full width regardless if we use one column or two (it
        // just looks better that way)
        formLayout.setColspan(title, 2);
        formLayout.setColspan(avatarField, 2);
        formLayout.setColspan(errorMessage, 2);
        formLayout.setColspan(submitButton, 2);

        // Add some styles to the error message to make it pop out
        errorMessage.getStyle().set("color", "var(--lumo-error-text-color)");
        errorMessage.getStyle().set("padding", "15px 0");

        // Add the form to the page
        add(formLayout);

        binder = new BeanValidationBinder<>(User.class);

        // Basic name fields that are required to fill in
        binder.forField(firstnameField).asRequired().bind("firstName");
        binder.forField(lastnameField).asRequired().bind("lastName");

        // EmailField uses a Validator that extends one of the built-in ones.
        binder.forField(emailField).asRequired("Value is not a valid email address").bind("email");

        // Another custom validator, this time for passwords
        binder.forField(passwordField1).asRequired().withValidator(this::passwordValidator) .bind("password");

        passwordField2.addValueChangeListener(e -> {
            // The user has modified the second field, now we can validate and show errors.
            // See passwordValidator() for how this flag is used.
            enablePasswordValidation = true;

            binder.validate();
        });

        // A label where bean-level error messages go
        binder.setStatusLabel(errorMessage);

        // And finally the submit button
        submitButton.addClickListener(e -> {
            validateAndSave();
            LoginView.signUpDialog.close();
        });

    }

    /**
     * We call this method when form submission has succeeded
     */
    private void showSuccess() {
        Notification notification = Notification.show("Your Account Has Been Created ");
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        UI.getCurrent().navigate("login");
    }

    /**
     * Method to validate that:
     * <p>
     * 1) Password is at least 8 characters long
     * <p>
     * 2) Values in both fields match each other
     */
    private ValidationResult passwordValidator(String pass1, ValueContext ctx) {

        /*
         * Just a simple length check. A real version should check for password
         * complexity as well!
         */
        if (pass1 == null || pass1.length() < 8) {
            return ValidationResult.error("Password should be at least 8 characters long");
        }

        if (!enablePasswordValidation) {
            // user hasn't visited the field yet, so don't validate just yet, but next time.
            enablePasswordValidation = true;
            return ValidationResult.ok();
        }

        String pass2 = passwordField2.getValue();

        if (pass1 != null && pass1.equals(pass2)) {
            return ValidationResult.ok();
        }

        return ValidationResult.error("Passwords do not match");
    }

    /**
     * Method that demonstrates using an external validator. Here we ask the backend
     * if this handle is already in use.
     */
    private void validateAndSave() {
        if (binder.isValid()) {
            User newUser = new User();
            newUser.setFirstName(firstnameField.getValue());
            newUser.setLastName(lastnameField.getValue());
            newUser.setEmail(emailField.getValue());
            newUser.setPassword(passwordField1.getValue());
            newUser.setUsername(usernameField.getValue());
            userService.save(newUser);
            showSuccess();
        }
        else
        {
            Notification.show("Save error");
        }
    }
}

