package com.bilshare.ui.views.list;


import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.*;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.shared.Registration;
import com.bilshare.backend.entity.Product;
import com.bilshare.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import com.bilshare.backend.entity.Product;
import com.bilshare.backend.data.Category;
import com.bilshare.backend.data.Type;


public class ProductForm extends FormLayout {

    TextField productName = new TextField("Product Name");
    TextField additionalInfo = new TextField("Additional Info");
    EmailField email = new EmailField("Email");
    ComboBox<String> type = new ComboBox<>("Type");
    ComboBox<String> category = new ComboBox("Category");
    private NumberField price  = new NumberField("Price");
    private TextField seller;



    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    @Autowired
    private ProductService productService;

    Binder<Product> binder = new BeanValidationBinder<>(Product.class);

    public ProductForm(ProductService productService) {
        binder = new BeanValidationBinder<>(Product.class);
        this.productService = productService;
        setClassName("product-form");

        // Product Name Text Field
        productName.setWidth("100%");
        productName.setRequired(true);
        productName.setValueChangeMode(ValueChangeMode.EAGER);

        // Price Text Field
        price.setWidth("%100");
        price.setSuffixComponent(new Span("₺"));
        //price.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
        price.setValueChangeMode(ValueChangeMode.EAGER);

        // Type ComboBox
        type.setItems(Type.BOOKS.toString(), Type.LECTURE_NOTES.toString(), Type.OTHER.toString());

        // Category CheckBox
        category.setItems(Category.ENGINEERING.toString(), Category.COMPUTER_SCIENCE.toString(), Category.PHYSICS.toString(),
                Category.BIOLOGY.toString(), Category.CHEMISTRY.toString(), Category.ECONOMICS.toString(),
                Category.LANGUAGE.toString(), Category.LAW.toString(), Category.MANAGEMENT.toString(), Category.MUSIC.toString());


        // seller username
        seller = new TextField("Your Username");
        seller.setPlaceholder("Type your username here...");

        binder.bindInstanceFields(this);

        add(productName, price, type,
                category, additionalInfo, seller, createButtonsLayout());

    }

    public void setProduct(Product product) {
        binder.setBean(product);
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
    public static abstract class ProductFormEvent extends ComponentEvent<ProductForm> {
      private Product product;

      protected ProductFormEvent(ProductForm source, Product product) {
        super(source, false);
        this.product = product;
      }

      public Product getProduct() {
        return product;
      }
    }

    public static class SaveEvent extends ProductFormEvent {
      SaveEvent(ProductForm source, Product product) {
        super(source, product);
      }
    }

    public static class DeleteEvent extends ProductFormEvent {
      DeleteEvent(ProductForm source, Product product) {
        super(source, product);
      }

    }

    public static class CloseEvent extends ProductFormEvent {
      CloseEvent(ProductForm source) {
        super(source, null);
      }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
      return getEventBus().addListener(eventType, listener);
    }
}
