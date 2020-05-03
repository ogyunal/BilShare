package com.bilshare.bilshare.bookstore.ui.adverts;

import com.bilshare.bilshare.bookstore.ui.MainLayout;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;
import com.bilshare.bilshare.bookstore.backend.data.Book;


/**
 * Showing products in more detail version.
 *
 */

@Route(value = "Book", layout = MainLayout.class)
@PageTitle("Book")
public class BookView extends VerticalLayout {


    private Book book;
    private RouteConfiguration configuration = RouteConfiguration.forSessionScope();

    public BookView(){
        buildUI();
    }

    public void buildUI(){
        setSizeFull();

        Grid<Book> grid = new Grid<>(Book.class);
        grid.setMaxWidth("800px");
        grid.setWidth("100%");
        setHorizontalComponentAlignment(Alignment.CENTER, grid);


        grid.addItemClickListener(saveEvent -> {
            Book toShow = saveEvent.getItem();

        });

        H3 title = new H3("Book Extended Form");
        TextField bookNameField = new TextField("Book Name");
        TextField writerNameField = new TextField("Writer Name");
        TextField categoryField = new TextField("Category of the book is");
        TextField priceField = new TextField("Price of the book is");
        FormLayout form = new FormLayout(title, bookNameField, writerNameField, categoryField, priceField);


        form.setMaxWidth("400px");
        form.getStyle().set("margin", "0 auto");
        add(form);
    }
}


