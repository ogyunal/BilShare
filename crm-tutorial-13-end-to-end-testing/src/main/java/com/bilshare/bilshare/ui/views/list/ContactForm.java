package com.bilshare.bilshare.ui.views.list;

import com.bilshare.bilshare.backend.entity.Item;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.shared.Registration;
import com.bilshare.bilshare.backend.entity.Product;

import java.util.List;

public class ContactForm extends FormLayout {

    TextField firstName = new TextField("First name");
    TextField lastName = new TextField("Last name");
    EmailField email = new EmailField("Email");
    ComboBox<Item.Status> status = new ComboBox<>("Status");
    ComboBox<Product> company = new ComboBox<>("Company");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    Binder<Item> binder = new BeanValidationBinder<>(Item.class);

    public ContactForm(List<Product> companies) {
        addClassName("contact-form");

        binder.bindInstanceFields(this);
        status.setItems(Item.Status.values());
        company.setItems(companies);
        company.setItemLabelGenerator(Product::getName);

        add(
            firstName,
            lastName,
            email,
            status,
            company,
            createButtonsLayout()
        );
    }

    public void setContact(Item item) {
        binder.setBean(item);
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        save.addClickListener(click -> validateAndSave());
        delete.addClickListener(click -> fireEvent(new DeleteEvent(this, binder.getBean())));
        close.addClickListener(click -> fireEvent(new CloseEvent(this)));

        binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        if (binder.isValid()) {
            fireEvent(new SaveEvent(this, binder.getBean()));
        }
    }

    // Events
    public static abstract class ContactFormEvent extends ComponentEvent<ContactForm> {
      private Item item;

      protected ContactFormEvent(ContactForm source, Item item) {
        super(source, false);
        this.item = item;
      }

      public Item getItem() {
        return item;
      }
    }

    public static class SaveEvent extends ContactFormEvent {
      SaveEvent(ContactForm source, Item item) {
        super(source, item);
      }
    }

    public static class DeleteEvent extends ContactFormEvent {
      DeleteEvent(ContactForm source, Item item) {
        super(source, item);
      }

    }

    public static class CloseEvent extends ContactFormEvent {
      CloseEvent(ContactForm source) {
        super(source, null);
      }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
      return getEventBus().addListener(eventType, listener);
    }
}
