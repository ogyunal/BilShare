package com.bilshare.bilshare.bookstore.ui.inventory;


import com.bilshare.bilshare.bookstore.backend.entity.Product;
import com.bilshare.bilshare.bookstore.backend.service.ProductService;
import com.vaadin.flow.component.grid.Grid;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Grid of products, handling the visual presentation and filtering of a set of
 * items. This version uses an in-memory data source that is suitable for small
 * data sets.
 */
public class ProductGrid extends Grid<Product> {

    @Autowired
    private ProductService productService;

    public ProductGrid(ProductService productService) {
        super(Product.class);
        this.productService = productService;
        setSizeFull();
        configureGrid();
        updateList();
    }

    private void configureGrid() {
        addClassName("product-grid");
        setSizeFull();
        setColumns("seller", "productName", "price", "type", "category");
        getColumns().forEach(col -> col.setAutoWidth(true));
    }

    public void updateList() {
        setItems(productService.findAll());
    }
}
