package com.bilshare.ui.views.list;


import com.bilshare.backend.CurrentUser;
import com.bilshare.backend.data.AvatarImage;
import com.bilshare.ui.views.signup.AvatarField;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.*;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.bilshare.backend.entity.Product;
import com.bilshare.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import com.bilshare.backend.data.Category;
import com.bilshare.backend.data.Type;

/**
 * ProductForm class which is a form for adding a new product or viewing a product
 * @author BilShare
 * @version 1.0
 */
public class ProductForm extends FormLayout {

    // properties
    TextField productName;
    TextArea additionalInfo;
    ComboBox<String> type;
    ComboBox<String> category;
    private NumberField price;
    private Product newProduct;
    private AvatarField imageField = new AvatarField("Select Product image");
    private AvatarImage productImage = new AvatarImage();
    private HorizontalLayout buttonLayout;
    Button save;
    Button delete;
    Button clean;
    Binder<Product> binder;
    @Autowired
    ProductService productService;

    // constructor
    public ProductForm(ProductService productService) {
        // initializing
        this.productService = productService;
        productName = new TextField("Product Name");
        additionalInfo = new TextArea("Additional Info");
        type = new ComboBox<>("Type");
        category = new ComboBox("Category");
        price  = new NumberField("Price");
        binder = new BeanValidationBinder<>(Product.class);

        // product name text field
        productName.setWidth("100%");
        productName.setRequired(true);
        productName.setValueChangeMode(ValueChangeMode.EAGER);

        // price text field
        price.setWidth("%100");
        price.setSuffixComponent(new Span("₺"));
        price.setValueChangeMode(ValueChangeMode.EAGER);

        // type comboBox
        type.setItems(Type.BOOKS.toString(), Type.LECTURE_NOTES.toString(), Type.OTHER.toString());

        // category checkBox
        category.setItems(Category.ENGINEERING.toString(), Category.COMPUTER_SCIENCE.toString(), Category.PHYSICS.toString(),
                Category.BIOLOGY.toString(), Category.CHEMISTRY.toString(), Category.ECONOMICS.toString(), Category.MATHEMATICS.toString(),
                Category.LANGUAGE.toString(), Category.LAW.toString(), Category.MANAGEMENT.toString(), Category.MUSIC.toString());

        // binding the fields to the Product class
        binder.bindInstanceFields(this);

        // adding components to the form
        add(productName, price, type,
                category, additionalInfo,imageField);
    }

    // methods
    /**
     * This method sets the binder to the current product
     * @param product is the current product
     */
    public void setProduct(Product product) {
        binder.setBean(product);
    }

    /**
     * This method creates the button layout
     */
    public void createButtonsLayout() {
        // initializing
        save = new Button("Add Advert");
        delete = new Button("Delete");
        clean = new Button("Clean");
        buttonLayout = new HorizontalLayout();

        // adding the theme
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        clean.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        // adding click listeners
        save.addClickShortcut(Key.ENTER);
        save.addClickListener(click -> {validateAndSave(); showSuccess(); cleanForm();});
        clean.addClickListener(click -> cleanForm());

        // enabling the save button according to the validity
        binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));

        // adding components to layout
        buttonLayout.add(save, clean);

        // centering the components
        buttonLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        // adding the layout to form
        add(buttonLayout);

    }

    /**
     * This method checks if the input values are valid and saves it to the repository
     */
    private void validateAndSave() {
        // checking whether the binder is valid or not
        if ( binder.isValid()) {
            productImage = imageField.getValue();
            newProduct = new Product(CurrentUser.getUser().getUsername());
            newProduct.setProductName(productName.getValue());
            newProduct.setPrice(price.getValue());
            newProduct.setCategory(category.getValue());
            newProduct.setType(type.getValue());
            newProduct.setAdditionalInfo(additionalInfo.getValue());
            productService.save(newProduct);
            // setting binder to null
            setProduct(null);
        }
        else {
            // show error message
            Notification notification = Notification.show("Save error");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        }
    }

    /**
     * This method shows a notification if the advert is added successfully
     */
    private void showSuccess() {
        Notification notification = Notification.show("Your Advert Has Been Created ");
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        // navigating the user back to advert list
        UI.getCurrent().navigate("");
    }

    /**
     * This method cleans the form
     */
    private void cleanForm() {
        productName.setValue("");
        price.setValue(0.0);
        category.setValue("");
        additionalInfo.setValue("");
        type.setValue("");
    }

    /**
     * This method disables user to manipulate the form
     * @param readOnly
     */
    public void readOnly(boolean readOnly) {
        productName.setReadOnly(readOnly);
        price.setReadOnly(readOnly);
        category.setReadOnly(readOnly);
        additionalInfo.setReadOnly(readOnly);
        type.setReadOnly(readOnly);
        imageField.setVisible(false);
    }
}
