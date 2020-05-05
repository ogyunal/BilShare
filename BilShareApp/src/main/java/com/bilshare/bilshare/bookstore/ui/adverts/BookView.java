package com.bilshare.bilshare.bookstore.ui.adverts;

import com.bilshare.bilshare.bookstore.ui.MainLayout;
import com.bilshare.bilshare.bookstore.ui.signup.data.AvatarImage;
import com.bilshare.bilshare.bookstore.ui.signup.data.UserDetails;
import com.bilshare.bilshare.bookstore.ui.signup.data.UserDetailsService;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;
import com.bilshare.bilshare.bookstore.backend.data.Book;
import com.vaadin.flow.shared.Registration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Showing products in more detail version.
 *
 */


public class BookView extends VerticalLayout {

    private Book book;

    H3 title = new H3("Book Extended Form");
    TextField name = new TextField("Book Name");
    TextField author = new TextField("Writer Name");
    TextField version = new TextField("Version of the book");
    TextField relatedCourse = new TextField("Category of the book is");
    TextField price = new TextField("Price of the book is");
    TextField additionalInfo = new TextField("Additional information");
    AvatarImage photo = new AvatarImage();
    Binder<Book> bookBinder;

    public BookView(@Autowired Book book){
        this.book=book;
        buildUI();
    }

    public void buildUI(){

        FormLayout form = new FormLayout(title, name, author, version, relatedCourse,price,additionalInfo);

        form.setMaxWidth("400px");
        form.getStyle().set("margin", "0 auto");
        add(form);

        addClickShortcut(Key.ESCAPE);

        bookBinder = new BeanValidationBinder<Book>(Book.class);

        // Basic name fields that are required to fill in
        bookBinder.forField(name).asRequired().bind("name");
        bookBinder.forField(author).asRequired().bind("author");
        bookBinder.forField(version).asRequired().bind("version");
        bookBinder.forField(relatedCourse).asRequired().bind("course");
        bookBinder.forField(price).bind("price");
        bookBinder.forField(additionalInfo).bind("Info");
    }


    // Events
    public static abstract class BookViewEvent extends ComponentEvent<BookView> {
        private Book book;

        protected BookViewEvent(BookView bookView, Book book) {
            super(bookView, false);
            this.book = book;
        }

        public Book getBook() {
            return book;
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}



