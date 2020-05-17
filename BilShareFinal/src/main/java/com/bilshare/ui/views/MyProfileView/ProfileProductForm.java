package com.bilshare.ui.views.MyProfileView;

import com.bilshare.backend.data.AvatarImage;
import com.bilshare.backend.data.Category;
import com.bilshare.backend.data.Type;
import com.bilshare.backend.entity.Product;
import com.bilshare.backend.service.ProductService;
import com.bilshare.ui.views.signup.AvatarField;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfileProductForm extends FormLayout {
    TextField productName = new TextField("Product Name");
    TextArea additionalInfo = new TextArea("Additional Info");
    EmailField email = new EmailField("Email");
    ComboBox<String> type = new ComboBox<>("Type");
    ComboBox<String> category = new ComboBox("Category");
    private NumberField price  = new NumberField("Price");
    private TextField seller;
    private Product newProduct;
    //private AvatarField imageField = new AvatarField("Select Product image");

    private AvatarImage productImage = new AvatarImage();

    public AvatarImage getProductImage() {
        return productImage;
    }

    Button save = new Button("Add Advert");
    Button delete = new Button("Delete");
    Button clean = new Button("Clean");
    Button update ;

    @Autowired
    ProductService productService;

    Binder<Product> binder;

    public ProfileProductForm(ProductService productService) {
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
                Category.BIOLOGY.toString(), Category.CHEMISTRY.toString(), Category.ECONOMICS.toString(), Category.MATHEMATICS.toString(),
                Category.LANGUAGE.toString(), Category.LAW.toString(), Category.MANAGEMENT.toString(), Category.MUSIC.toString());


        // seller username
        seller = new TextField("Your Username");
        seller.setPlaceholder("Type your username here...");

        binder.bindInstanceFields(this);
        update = new Button("Update");


        update.addClickListener(evt-> productService.setType(productName.getValue(),type.getValue()));
        update.addClickListener(evt-> productService.setCategory(productName.getValue(),category.getValue()));
        update.addClickListener(evt-> productService.setPrice(productName.getValue(),price.getValue()));
        update.addClickListener(evt-> productService.setInfo(productName.getValue(),additionalInfo.getValue()));
        update.addClickListener(evt-> productService.setName(productName.getValue(),productName.getValue()));
        update.addClickShortcut(Key.ENTER);

        add(productName, price, type,
                category, additionalInfo, seller,update);

    }


    public void setProduct(Product product) {
        binder.setBean(product);
    }

//    public void createButtonsLayout() {
//        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
//        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
//        clean.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
//
//        save.addClickShortcut(Key.ENTER);
//        //close.addClickShortcut(Key.ESCAPE);
//
//        save.addClickListener(click -> {validateAndSave(); showSuccess(); cleanForm();});
//        //delete.addClickListener(click -> fireEvent(new DeleteEvent(this, binder.getBean())));
//        clean.addClickListener(click -> cleanForm());
//
//        binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));
//        HorizontalLayout buttonLayout = new HorizontalLayout();
//        buttonLayout.add(save, clean);
//        buttonLayout.setAlignItems(FlexComponent.Alignment.CENTER);
//        buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
//        add(buttonLayout);
//
//    }

    private void validateAndSave() {
        if ( binder.isValid()) {
            newProduct = new Product(seller.getValue());
            newProduct.setProductName(productName.getValue());
            newProduct.setPrice(price.getValue());
            newProduct.setCategory(category.getValue());
            newProduct.setType(type.getValue());
            newProduct.setAdditionalInfo(additionalInfo.getValue());
            //newProduct.setImage(imageField.);
            productService.save(newProduct);
            setProduct(null);
        } else {
            Notification.show("Save error");
        }
    }

    private void showSuccess() {
        Notification notification = Notification.show("Your Advert Has Been Created ");
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        UI.getCurrent().navigate("");
    }

    private void cleanForm(){
        productName.setValue("");
        price.setValue(0.0);
        category.setValue("");
        additionalInfo.setValue("");
        type.setValue("");
        seller.setValue("");
    }


    // Events
    /*public static abstract class ProductFormEvent extends ComponentEvent<ProductForm> {
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
    }*/
}
