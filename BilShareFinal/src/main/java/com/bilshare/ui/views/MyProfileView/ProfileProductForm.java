package com.bilshare.ui.views.MyProfileView;

import com.bilshare.backend.data.AvatarImage;
import com.bilshare.backend.data.Category;
import com.bilshare.backend.data.Type;
import com.bilshare.backend.entity.Product;
import com.bilshare.backend.service.ProductService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
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
    ComboBox<String> type = new ComboBox<>("Type");
    ComboBox<String> category = new ComboBox("Category");
    private NumberField price  = new NumberField("Price");

    private AvatarImage productImage = new AvatarImage();

    private Button update;
    private Button delete;

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

        binder.bindInstanceFields(this);

        update = new Button("Update", VaadinIcon.UPLOAD.create());
        update.addThemeVariants(ButtonVariant.LUMO_PRIMARY);


        update.addClickListener(evt-> {
                    productService.setType(binder.getBean(),type.getValue());
                    productService.setCategory(binder.getBean(),category.getValue());
                    productService.setPrice(binder.getBean(),price.getValue());
                    productService.setInfo(binder.getBean(),additionalInfo.getValue());
                    productService.setName(binder.getBean(),productName.getValue());
                    showSuccess();
        });

        update.addClickShortcut(Key.ENTER);

        delete = new Button("Delete Product", VaadinIcon.CLOSE_CIRCLE.create());
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        delete.addClickListener(evt-> {
                    productService.delete(binder.getBean());
                    showDeleteSuccess();
                });

        add(productName, price, type,
                category, additionalInfo, update, delete);

    }


    public void setProduct(Product product) {
        binder.setBean(product);
    }

    public AvatarImage getProductImage() {
        return productImage;
    }

    private void showSuccess() {
        if (binder.isValid()){
            Notification notification = Notification.show("Your Advert Has Been Updated ");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            UI.getCurrent().getPage().reload();
        }
    }

    private void showDeleteSuccess() {
        Notification notification = Notification.show("Your Advert Has Been Deleted ");
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        UI.getCurrent().getPage().reload();
    }

    private void cleanForm(){
        productName.setValue("");
        price.setValue(0.0);
        category.setValue("");
        additionalInfo.setValue("");
        type.setValue("");
    }
}
