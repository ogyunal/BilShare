package com.bilshare.bilshare.ui.views.list;

import com.bilshare.bilshare.backend.entity.Item;
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
            Grid<Item> grid = listView.grid;
            Item firstItem = getFirstItem(grid);

            ContactForm form = listView.form;

            Assert.assertFalse(form.isVisible());
    		grid.asSingleSelect().setValue(firstItem);
            Assert.assertTrue(form.isVisible());
            Assert.assertEquals(firstItem, form.binder.getBean());
        }

    	private Item getFirstItem(Grid<Item> grid) {
    		return( (ListDataProvider<Item>) grid.getDataProvider()).getItems().iterator().next();
    	}

}
