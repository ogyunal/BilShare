package com.bilshare.bilshare.ui.views.dashboard;

import com.bilshare.bilshare.backend.service.ProductService;
import com.bilshare.bilshare.ui.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.bilshare.bilshare.backend.service.ItemService;

import java.util.Map;

@PageTitle("Dashboard | Vaadin CRM")
@Route(value = "dashboard", layout = MainLayout.class)
public class DashboardView extends VerticalLayout {

    private final ItemService itemService;
    private final ProductService productService;

    public DashboardView(ItemService itemService,
                         ProductService productService) {
        this.itemService = itemService;
        this.productService = productService;

        addClassName("dashboard-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(
            getContactStats(),
            getCompaniesChart()
        );
    }

    private Span getContactStats() {
        Span stats = new Span(itemService.count() + " contacts");
        stats.addClassName("contact-stats");

        return stats;
    }

    private Component getCompaniesChart() {
        Chart chart = new Chart(ChartType.PIE);

        DataSeries dataSeries = new DataSeries();
        Map<String, Integer> stats = productService.getStats();
        stats.forEach((name, number) ->
            dataSeries.add(new DataSeriesItem(name, number)));

        chart.getConfiguration().setSeries(dataSeries);
        return chart;
    }
}
