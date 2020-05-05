package com.bilshare.bilshare.bookstore.ui.adverts;

import com.bilshare.bilshare.bookstore.ui.MainLayout;
import com.bilshare.bilshare.bookstore.ui.signup.data.AvatarImage;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;
import com.bilshare.bilshare.bookstore.backend.data.Book;
import com.vaadin.flow.shared.Registration;

import java.util.List;


/**
 * Showing products in more detail version.
 *
 */

@Route(value = "Book", layout = MainLayout.class)
@PageTitle("Book")
public class BookView extends VerticalLayout {


    private Book book;
    private RouteConfiguration configuration = RouteConfiguration.forSessionScope();
    H3 title = new H3("Book Extended Form");
    Label name = new Label("Book Name");
    Label author = new Label("Writer Name");
    Label version = new Label("Version of the book");
    Label relatedCourse = new Label("Category of the book is");
    Label price = new Label("Price of the book is");
    Label additionalInfo = new Label("Additional information");
    AvatarImage photo = new AvatarImage();
    Binder<Book> bookBinder = new BeanValidationBinder<>(Book.class);

    public BookView(){
        buildUI();
    }

    public void buildUI(){
        bookBinder.bindInstanceFields(this);

        FormLayout form = new FormLayout(title, name, author, version, relatedCourse,price,additionalInfo);

        form.setMaxWidth("400px");
        form.getStyle().set("margin", "0 auto");
        add(form);

        addClickShortcut(Key.ESCAPE);

    }

    public void setBook(Book book){
        bookBinder.setBean(book );

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



