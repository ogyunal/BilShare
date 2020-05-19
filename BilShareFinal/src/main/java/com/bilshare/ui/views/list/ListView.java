package com.bilshare.ui.views.list;
import com.bilshare.backend.entity.Product;
import com.bilshare.ui.MainLayout;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * ListView class creating grids and dialog to show product in more detailed version
 * @author BilShare
 * @version 1.0
 */
@Component
@Scope("prototype")
@Route(value = "", layout = MainLayout.class)
@PageTitle("Advert List | BilShare")
@RestController
public class ListView extends VerticalLayout {

    //properties
    private Dialog showProdDialog = new Dialog();
    ProductForm form;
    Grid<Product> grid = new Grid<>(Product.class);
    TextField filterText = new TextField();
    @Autowired
    ProductService productService;

    //constructor
    public ListView(ProductService productService) {

        // initializing the properties
        this.productService = productService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        form = new ProductForm(productService);
        form.readOnly(true);

        // adding form to dialog
        showProdDialog.add(form);

        //setting width and height
        showProdDialog.setWidth("40");
        showProdDialog.setHeight("100");
        showProdDialog.close();

        //adding toolbar , grid and dialog to layout
        add(getToolBar(), grid, showProdDialog);
        updateList();
        closeEditor();
    }

    //program code
    /**
     *getToolBar() filter products by their name
     *@return toolbar
     */
    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());
        setSizeFull();
        HorizontalLayout toolbar = new HorizontalLayout(filterText);
        toolbar.addClassName("toolbar");
        return toolbar;
    }
    /**
     * configureGrid() arrange grid, set columns and add action to grids.
     */
    private void configureGrid() {
        //setting grid properties
        grid.addClassName("product-grid");
        grid.setSizeFull();
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);
        final DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setMinimumFractionDigits(2);
        grid.setColumns("image", "productName", "seller", "type", "category");
        final String priceTemplate = "<div style='text-align: right'>[[item.price]]</div>";
        grid.addColumn(TemplateRenderer.<Product>of(priceTemplate)
                .withProperty("price", product -> decimalFormat.format(product.getPrice()) + " ₺"))
                .setHeader("Price")
                .setComparator(Comparator.comparing(Product::getPrice))
                .setFlexGrow(3);
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        //adding changeListener to all grid
        grid.asSingleSelect().addValueChangeListener(evt -> showProduct(evt.getValue()));
    }
    /**
     *closeEditor() close the dialog form
     */
    private void closeEditor() {
        form.setProduct(null);
        showProdDialog.close();
    }
    /**
     *updateList() after filtering shows the products
     */
    private void updateList() {
        grid.setItems(productService.findAll(filterText.getValue()));
    }
    /**
     *showProduct() shows product in the dialog
     *@param product Product
     */
    public void showProduct(Product product) {
        form.setProduct(product);
        showProdDialog.open();
    }
}
