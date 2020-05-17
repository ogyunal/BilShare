package com.bilshare.bilshare.ui.views.list;

import com.bilshare.bilshare.backend.entity.Item;
import com.bilshare.bilshare.backend.entity.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ItemFormTest {
    private List<Product> companies;
    private Item marcUsher;
    private Product product1;
    private Product product2;

    @Before
    public void setupData() {
        companies = new ArrayList<>();
        product1 = new Product("Vaadin Ltd");
        product2 = new Product("IT Mill");
        companies.add(product1);
        companies.add(product2);

        marcUsher = new Item();
        marcUsher.setFirstName("Marc");
        marcUsher.setLastName("Usher");
        marcUsher.setEmail("marc@usher.com");
        marcUsher.setStatus(Item.Status.NotContacted);
        marcUsher.setProduct(product2);
    }

    @Test
    public void formFieldsPopulated() {
        ContactForm form = new ContactForm(companies);
        form.setContact(marcUsher);
        Assert.assertEquals("Marc", form.firstName.getValue());
        Assert.assertEquals("Usher", form.lastName.getValue());
        Assert.assertEquals("marc@usher.com", form.email.getValue());
        Assert.assertEquals(product2, form.company.getValue());
        Assert.assertEquals(Item.Status.NotContacted, form.status.getValue());
    }

    @Test
        public void saveEventHasCorrectValues() {
            ContactForm form = new ContactForm(companies);
            Item item = new Item();
            form.setContact(item);

            form.firstName.setValue("John");
            form.lastName.setValue("Doe");
            form.company.setValue(product1);
            form.email.setValue("john@doe.com");
            form.status.setValue(Item.Status.Customer);

            AtomicReference<Item> savedContactRef = new AtomicReference<>(null);
            form.addListener(ContactForm.SaveEvent.class, e -> {
                savedContactRef.set(e.getItem());
            });
            form.save.click();
            Item savedItem = savedContactRef.get();

            Assert.assertEquals("John", savedItem.getFirstName());
            Assert.assertEquals("Doe", savedItem.getLastName());
            Assert.assertEquals("john@doe.com", savedItem.getEmail());
            Assert.assertEquals(product1, savedItem.getProduct());
            Assert.assertEquals(Item.Status.Customer, savedItem.getStatus());
        }

}
