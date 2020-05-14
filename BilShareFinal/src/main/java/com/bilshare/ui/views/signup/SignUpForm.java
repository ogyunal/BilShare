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
import com.vaadin.flow.shared.Registration;
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

        // Create a FormLayout with all our components. The FormLayout doesn't have any
        // logic (validation, etc.), but it allows us to configure Responsiveness from
        // Java code and its defaults looks nicer than just using a VerticalLayout.
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

        /*
         * Set up form functionality
         */

        /*
         * Binder is a form utility class provided by Vaadin. Here, we use a specialized
         * version to gain access to automatic Bean Validation (JSR-303). We provide our
         * data class so that the Binder can read the validation definitions on that
         * class and create appropriate validators. The BeanValidationBinder can
         * automatically validate all JSR-303 definitions, meaning we can concentrate on
         * custom things such as the passwords in this class.
         */
        binder = new BeanValidationBinder<>(User.class);

        // Basic name fields that are required to fill in
        binder.forField(firstnameField).asRequired().bind("firstName");
        binder.forField(lastnameField).asRequired().bind("lastName");

        // The handle has a custom validator, in addition to being required. Some values
        // are not allowed, such as 'admin'; this is checked in the validator.
        //binder.forField(usernameField).withValidator(this::validateHandle).asRequired().bind("handle");

        // Here we use our custom Vaadin component to handle the image portion of our
        // data, since Vaadin can't do that for us. Because the AvatarField is of type
        // HasValue<AvatarImage>, the Binder can bind it automatically. The avatar is
        // not required and doesn't have a validator, but could.
        //binder.forField(avatarField).bind("avatar");

        // EmailField uses a Validator that extends one of the built-in ones.
        // Note that we use 'asRequired(Validator)' instead of
        // 'withValidator(Validator)'; this method allows 'asRequired' to
        // be conditional instead of always on. We don't want to require the email if
        // the user declines marketing messages.
        binder.forField(emailField).asRequired("Value is not a valid email address").bind("email");

        // Another custom validator, this time for passwords
        binder.forField(passwordField1).asRequired().withValidator(this::passwordValidator) .bind("password");
        // We won't bind passwordField2 to the Binder, because it will have the same
        // value as the first field when correctly filled in. We just use it for
        // validation.

        // The second field is not connected to the Binder, but we want the binder to
        // re-check the password validator when the field value changes. The easiest way
        // is just to do that manually.
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
     *//*
    private ValidationResult validateHandle(String handle, ValueContext ctx) {

        String errorMsg = service.validateHandle(handle);

        if (errorMsg == null) {
            return ValidationResult.ok();
        }

        return ValidationResult.error(errorMsg);
    }*/

    private void validateAndSave() {
        if (binder.isValid()) {
            User newUser = new User();
            newUser.setFirstName(firstnameField.getValue());
            newUser.setLastName(lastnameField.getValue());
            //newUser.setEmail(emailField.getValue());
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

    // Events
    /*public static abstract class SignUpFormEvent extends ComponentEvent<SignUpForm> {
        private User user;

        protected SignUpFormEvent(SignUpForm source, User user) {
            super(source, false);
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }

    public static class SaveEvent extends SignUpForm.SignUpFormEvent {
        SaveEvent(SignUpForm source, User user) {
            super(source, user);
        }
    }

    public static class DeleteEvent extends SignUpForm.SignUpFormEvent {
        DeleteEvent(SignUpForm source, User user) {
            super(source, user);
        }

    }

    public static class CloseEvent extends SignUpForm.SignUpFormEvent {
        CloseEvent(SignUpForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }*/
}

