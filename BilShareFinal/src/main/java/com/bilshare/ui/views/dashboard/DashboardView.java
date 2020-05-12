package com.bilshare.ui.views.dashboard;

import com.bilshare.ui.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.bilshare.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@PageTitle("Dashboard | Bilshare")
@Route(value = "dashboard", layout = MainLayout.class)
public class DashboardView extends VerticalLayout {

    @Autowired
    private final ProductService productService;


    public DashboardView(ProductService productService) {
        this.productService = productService;

        addClassName("dashboard-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(
            getProductStats()
            //getCategoriesChart()
        );
    }

    private Span getProductStats() {
        Span stats = new Span(productService.count() + " products");
        stats.addClassName("product-stats");

        return stats;
    }

   /* private Component getCategoriesChart() {
        Chart chart = new Chart(ChartType.PIE);

        DataSeries dataSeries = new DataSeries();
        Map<String, Integer> stats = productService.getStats();
        stats.forEach((name, number) ->
            dataSeries.add(new DataSeriesItem(name, number)));

        chart.getConfiguration().setSeries(dataSeries);
        return chart;
    }*/
}
