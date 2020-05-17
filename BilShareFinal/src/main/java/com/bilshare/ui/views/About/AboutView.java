package com.bilshare.ui.views.About;

import com.bilshare.ui.MainLayout;
import com.bilshare.ui.views.list.ListView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.bilshare.backend.service.ProductService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.event.ItemEvent;
import java.awt.font.TextLayout;

@Route(value = "about", layout = MainLayout.class)
@PageTitle("About | BilShare")
public class AboutView extends VerticalLayout {

    Label info;

    public AboutView() {
        VerticalLayout aboutInfo = new VerticalLayout();
        setAlignItems(Alignment.CENTER);
        info = new Label();
        info.setText("Bilshare is a web app that enables college students to sell and buy second hand course materials.\n " +
                "This app is created by Oğulcan Ünal,Yağmur Eryılmaz Elif Çenesiz, Berk Türkçapar, Melih Obut and İdil Yılmaz.");
        aboutInfo.add(info);
        add(aboutInfo );
    }
}