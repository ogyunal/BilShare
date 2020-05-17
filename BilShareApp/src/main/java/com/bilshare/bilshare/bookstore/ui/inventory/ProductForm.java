package com.bilshare.bilshare.bookstore.ui.inventory;


import com.berkturkcapar.bilshare.backend.entity.Category;
import com.berkturkcapar.bilshare.backend.data.Type;
import com.berkturkcapar.bilshare.backend.entity.Product;
import com.berkturkcapar.bilshare.backend.entity.User;
import com.berkturkcapar.bilshare.backend.service.ProductService;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToBigDecimalConverter;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.shared.Registration;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * A form for editing a single product.
 */
public class ProductForm extends FormLayout {

    private TextField productName;
    private NumberField price;
    //private CheckboxGroup<String> category;
    private ComboBox<String> category;
    private TextArea additionalInfo;
    private ComboBox<String> type;
    @Autowired
    private ProductService productService;
    private Button save;
    private Button cancel;
    private HorizontalLayout buttonLayout;

    private Binder<Product> binder;
    private TextField seller;
    private Product currentProduct;

    /*private static class PriceConverter extends StringToBigDecimalConverter {

        public PriceConverter() {
            super(BigDecimal.ZERO, "Cannot convert value to a number.");
        }

        @Override
        protected NumberFormat getFormat(Locale locale) {
            // Always display currency with two decimals
            final NumberFormat format = super.getFormat(locale);
            if (format instanceof DecimalFormat) {
                format.setMaximumFractionDigits(2);
                format.setMinimumFractionDigits(2);
            }
            return format;
        }
    }*/

    public ProductForm(ProductService productService) {
        binder = new BeanValidationBinder<>(Product.class);
        this.productService = productService;
        //currentProduct = new Product(VaadinSession.getCurrent().getAttribute("username").toString());
        binder.bindInstanceFields(this);

        setClassName("product-form");
        // Product Name Text Field
        productName = new TextField("Product name");
        productName.setWidth("100%");
        productName.setRequired(true);
        productName.setValueChangeMode(ValueChangeMode.EAGER);

        // Price Text Field
        price = new NumberField("Price", "Price");
        price.setSuffixComponent(new Span("₺"));
        price.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
        price.setValueChangeMode(ValueChangeMode.EAGER);

        // Type ComboBox
        type = new ComboBox();
        type.setPlaceholder("Type");
        type.setItems(Type.BOOKS.toString(), Type.LECTURE_NOTES.toString());

        // Category CheckBox
        category = new ComboBox();
        category.setPlaceholder("Category");
        category.setItems(Category.ENGINEERING.toString(), Category.COMPUTER_SCIENCE.toString(), Category.PHYSICS.toString(),
                Category.BIOLOGY.toString(), Category.CHEMISTRY.toString(), Category.ECONOMICS.toString(),
                Category.LANGUAGE.toString(), Category.LAW.toString(), Category.MANAGEMENT.toString(), Category.MUSIC.toString());
        //category.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);

        // Additional Info TextArea
        additionalInfo = new TextArea("Additional Info");
        additionalInfo.setPlaceholder("You can add anything you would like to say about the product...");

        binder.addStatusChangeListener(event -> {
            final boolean isValid = !event.hasValidationErrors();
            final boolean hasChanges = binder.hasChanges();
            save.setEnabled(hasChanges && isValid);
        });

        // seller username
        seller = new TextField("Your Username");
        seller.setPlaceholder("Type your username here...");

        // Save Button
        save = new Button("Save");
        save.setWidth("100%");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        save.addClickListener(click -> validateAndSave());
        save.addClickShortcut(Key.KEY_S, KeyModifier.CONTROL);

        // Cancel Button
        cancel = new Button("Cancel");
        cancel.setWidth("100%");
        cancel.addClickListener(click -> fireEvent(new CloseEvent(this)));
        cancel.addClickShortcut(Key.ESCAPE);

        buttonLayout = new HorizontalLayout();
        buttonLayout.add(save, cancel);

        add(productName, price, type,
                category, additionalInfo, seller, buttonLayout);

    }

    public static abstract class ProductFormEvent extends ComponentEvent<ProductForm> {
        private Product product;

        protected ProductFormEvent(ProductForm source, Product product) {
            super(source, false);
            this.product = product;
        }
    }

    private void validateAndSave() {
        if (binder.isValid()) {
            fireEvent(new SaveEvent(this, binder.getBean()));
        }
    }

    public static class CloseEvent extends ProductFormEvent {
        CloseEvent(ProductForm source) {
            super(source, null);
        }
    }

    public static class SaveEvent extends ProductFormEvent {
        SaveEvent(ProductForm source, Product product) {
            super(source, product);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
