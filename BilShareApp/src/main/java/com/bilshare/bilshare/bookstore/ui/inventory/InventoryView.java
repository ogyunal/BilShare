package com.bilshare.bilshare.bookstore.ui.inventory;

import com.bilshare.bilshare.bookstore.backend.entity.Product;
import com.bilshare.bilshare.bookstore.backend.service.ProductService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A view for performing create-read-update-delete operations on products.
 *
 * See also {@link InventoryViewLogic} for fetching the data, the actual CRUD
 * operations and controlling the view based on events from outside.
 */
@Route(value = "Inventory")
@RouteAlias(value = "")
public class InventoryView extends HorizontalLayout {

    public static final String VIEW_NAME = "Inventory";
    private final ProductGrid grid;
    private final ProductForm productForm;
    private TextField filter;
    private Dialog newProdDialog;

    @Autowired
    private ProductService productService;

    private Button newProduct;

    public InventoryView(ProductService productService) {
        // Sets the width and the height of InventoryView to "100%".
        this.productService = productService;
        setSizeFull();
        final HorizontalLayout topLayout = createTopBar();
        grid = new ProductGrid(productService);
        // Allows user to select a single row in the grid.
        //grid.asSingleSelect().addValueChangeListener(
                //event -> viewLogic.rowSelected(event.getValue()));
        productForm = new ProductForm(productService);
        final VerticalLayout barAndGridLayout = new VerticalLayout();
        barAndGridLayout.add(topLayout);
        barAndGridLayout.add(grid);
        barAndGridLayout.setFlexGrow(1, grid);
        barAndGridLayout.setFlexGrow(0, topLayout);
        barAndGridLayout.setSizeFull();
        barAndGridLayout.expand(grid);

        add(barAndGridLayout);
        newProdDialog = new Dialog();
        newProdDialog.add(productForm);
        newProdDialog.setSizeFull();
    }

    public HorizontalLayout createTopBar() {
        filter = new TextField();
        filter.setPlaceholder("Filter by name...");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.LAZY);
        filter.addValueChangeListener(e -> updateList());

        newProduct = new Button("New product");
        // Setting theme variant of new production button to LUMO_PRIMARY that
        // changes its background color to blue and its text color to white
        newProduct.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        newProduct.setIcon(VaadinIcon.PLUS_CIRCLE.create());
        newProduct.addClickListener(click -> showForm(true));

        // A shortcut to click the new product button by pressing ALT + N
        newProduct.addClickShortcut(Key.KEY_N, KeyModifier.ALT);
        final HorizontalLayout topLayout = new HorizontalLayout();
        topLayout.setWidth("100%");
        topLayout.add(filter);
        topLayout.add(newProduct);
        topLayout.setVerticalComponentAlignment(Alignment.START, filter);
        topLayout.expand(filter);
        return topLayout;
    }

    private void updateList() {
        grid.setItems(productService.findAll(filter.getValue()));
    }

    public void showError(String msg) {
        Notification.show(msg);
    }

    /**
     * Shows a temporary popup notification to the user.
     *
     * @see Notification#show(String)
     * @param msg
     */
    public void showNotification(String msg) {
        Notification.show(msg);
    }

    /**
     * Enables/Disables the new product button.
     *
     * @param enabled
     */
    //public void setNewProductEnabled(boolean enabled) {
        //newProduct.setEnabled(enabled);
    //}

    /**
     * Deselects the selected row in the grid.
     */
    public void clearSelection() {
        grid.getSelectionModel().deselectAll();
    }

    /**
     * Selects a row
     *
     * @param row
     */
    public void selectRow(Product row) {
        grid.getSelectionModel().select(row);
    }

    /**
     * Updates a product in the list of products.
     *
     * @param product
     */
    //public void updateProduct(Product product) {
        //dataProvider.save(product);
    //}

    /**
     * Removes a product from the list of products.
     *
     * @param product
     */
    public void removeProduct(Product product) {
        //dataProvider.delete(product);
    }

    /**
     * Displays user a form to edit a Product.
     *
     * @param product
     */
    //public void editProduct(Product product) {
        //showForm(product != null);
        //productForm.editProduct(product);
    //}

    /**
     * Shows and hides the new product form
     *
     * @param show
     */
    public void showForm(boolean show) {
        if(show)
            newProdDialog.open();
        else
            newProdDialog.close();
    }


   /* @Override
    public void afterNavigation(AfterNavigationEvent event) {
        grid.setItems(productService.findAll());
    }
*/
    //@Override
    //public void setParameter(BeforeEvent event,
                             //@OptionalParameter String parameter) {
        //viewLogic.enter(parameter);
    //}
}
