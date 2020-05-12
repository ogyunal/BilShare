package com.bilshare.ui.views.list;

import com.bilshare.backend.entity.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.bilshare.ui.views.list.ProductForm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ProductFormTest {
    private List<String> categories;
    private Product marcUsher;


/*    @Before
    public void setupData() {
        categories = new ArrayList<>();

        categories.add("category1");
        categories.add("category2");

        marcUsher = new Product();
        marcUsher.setProductName("Marc");
        marcUsher.setAdditionalInfo("Usher");
        marcUsher.setEmail("marc@usher.com");
        marcUsher.setType(Product.Type.Book);
        marcUsher.setCategory("category2");
    }*/

/*    @Test
    public void formFieldsPopulated() {
        ProductForm form = new ProductForm(categories);
        form.setProduct(marcUsher);
        Assert.assertEquals("Marc", form.productName.getValue());
        Assert.assertEquals("Usher", form.additionalInfo.getValue());
        Assert.assertEquals("marc@usher.com", form.email.getValue());
        Assert.assertEquals("category2", form.category.getValue());
        Assert.assertEquals(Product.Type.Note, form.type.getValue());
    }

    @Test
        public void saveEventHasCorrectValues() {
            ProductForm form = new ProductForm(productService);
            Product product = new Product();
            form.setProduct(product);

            form.productName.setValue("John");
            form.additionalInfo.setValue("Doe");
            form.category.setValue("category1");
            form.email.setValue("john@doe.com");
            form.type.setValue(Product.Type.Book);

            AtomicReference<Product> savedContactRef = new AtomicReference<>(null);
            form.addListener(ProductForm.SaveEvent.class, e -> {
                savedContactRef.set(e.getProduct());
            });
            form.save.click();
            Product savedProduct = savedContactRef.get();

            Assert.assertEquals("John", savedProduct.getProductName());
            Assert.assertEquals("Doe", savedProduct.getAdditionalInfo());
            Assert.assertEquals("john@doe.com", savedProduct.getEmail());
            Assert.assertEquals("category1", savedProduct.getCategory());
            Assert.assertEquals(Product.Type.Other, savedProduct.getType());
        }*/

}

