package com.bilshare.ui.views.list;


import com.bilshare.backend.entity.Product;
import com.bilshare.ui.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.text.DecimalFormat;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import java.util.Comparator;


import com.bilshare.backend.service.ProductService;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@Scope("prototype")
@Route(value = "", layout = MainLayout.class)
@PageTitle("Advert List | BilShare")
@RestController

public class ListView extends VerticalLayout {

    ProductForm form;
    Grid<Product> grid = new Grid<>(Product.class);
    TextField filterText = new TextField();

    private Dialog showProdDialog = new Dialog();


    @Autowired
    ProductService productService;

    public ListView(ProductService productService) {
        this.productService = productService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        form = new ProductForm(productService);
        form.readOnly(true);
        //form.addListener(ProductForm.SaveEvent.class, this::saveProduct);
        //form.addListener(ProductForm.DeleteEvent.class, this::saveProduct);
        //form.addListener(ProductForm.CloseEvent.class, e -> closeEditor());


        showProdDialog.add(form);
        showProdDialog.setWidth("40");
        showProdDialog.setHeight("100");
        showProdDialog.close();

        add(getToolBar(), grid, showProdDialog);
        updateList();
        closeEditor();
    }

//    private void saveProduct(ProductForm.DeleteEvent evt) {
//        productService.delete(evt.getProduct());
//        updateList();
//        closeEditor();
//    }
//
//    private void saveProduct(ProductForm.SaveEvent evt) {
//        productService.save(evt.getProduct());
//        updateList();
//        closeEditor();
//    }

    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Filter by name...");

        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());
        setSizeFull();

        //Button addProduct = new Button("Add Advert", click -> addProduct());

        HorizontalLayout toolbar = new HorizontalLayout(filterText);//, addProduct);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    /*private void addProduct() {
        grid.asSingleSelect().clear();
        editProduct(new Product());
    }*/

    private void configureGrid() {
        grid.addClassName("product-grid");
        grid.setSizeFull();
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);

        final DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setMinimumFractionDigits(2);
        grid.setColumns("image", "productName", "seller", "type", "category");
        // To change the text alignment of the column, a template is used.

        final String priceTemplate = "<div style='text-align: right'>[[item.price]]</div>";
        grid.addColumn(TemplateRenderer.<Product>of(priceTemplate)
                .withProperty("price", product -> decimalFormat.format(product.getPrice()) + " ₺"))
                .setHeader("Price")
                .setComparator(Comparator.comparing(Product::getPrice))
                .setFlexGrow(3);



        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(evt -> showProduct(evt.getValue()));
    }

    /*private void editProduct(Product product) {
        if (product == null) {
            closeEditor();
        } else {
            form.setProduct(product);
            //form.setVisible(true);
            //addClassName("editing");
            showProdDialog.open();
        }
    }*/

    private void closeEditor() {
        form.setProduct(null);
        //form.setVisible(false);
        //removeClassName("editing");
        showProdDialog.close();
    }

    private void updateList() {
        grid.setItems(productService.findAll(filterText.getValue()));
    }

    public void showProduct(Product product) {
        form.setProduct(product);
        //form.setVisible(true);
        showProdDialog.open();
    }

}
