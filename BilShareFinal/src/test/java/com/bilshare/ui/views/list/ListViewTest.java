package com.bilshare.ui.views.list;

import com.bilshare.backend.entity.Product;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.provider.ListDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListViewTest {

    @Autowired
    private ListView listView;

    @Test
        public void formShownWhenContactSelected() {
            Grid<Product> grid = listView.grid;
            Product firstProduct = getFirstItem(grid);

            ProductForm form = listView.form;

            Assert.assertFalse(form.isVisible());
    		grid.asSingleSelect().setValue(firstProduct);
            Assert.assertTrue(form.isVisible());
            Assert.assertEquals(firstProduct, form.binder.getBean());
        }

    	private Product getFirstItem(Grid<Product> grid) {
    		return( (ListDataProvider<Product>) grid.getDataProvider()).getItems().iterator().next();
    	}

}
