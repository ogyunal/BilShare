package com.bilshare.bilshare.ui.views.storefront;

import static com.bilshare.bilshare.ui.utils.FormattingUtils.HOUR_FORMATTER;
import static com.bilshare.bilshare.ui.utils.FormattingUtils.MONTH_AND_DAY_FORMATTER;
import static com.bilshare.bilshare.ui.utils.FormattingUtils.SHORT_DAY_FORMATTER;
import static com.bilshare.bilshare.ui.utils.FormattingUtils.WEEKDAY_FULLNAME_FORMATTER;
import static com.bilshare.bilshare.ui.utils.FormattingUtils.WEEK_OF_YEAR_FIELD;

import java.time.LocalDate;
import java.util.List;

import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.bilshare.bilshare.backend.data.entity.Order;
import com.bilshare.bilshare.backend.data.entity.OrderItem;
import com.bilshare.bilshare.backend.data.entity.OrderSummary;
import com.bilshare.bilshare.ui.utils.converters.OrderStateConverter;


/**
 * Help class to get ready to use TemplateRenderer for displaying order card list on the Storefront and Dashboard grids.
 * Using TemplateRenderer instead of ComponentRenderer optimizes the CPU and memory consumption.
 * <p>
 * In addition, component includes an optional header above the order card. It is used
 * to visually separate orders into groups. Technically all order cards are
 * equivalent, but those that do have the header visible create a visual group
 * separation.
 */


public class OrderCard {

	public static TemplateRenderer<Order> getTemplate() {
		return TemplateRenderer.of(
				  "<order-card"
				+ "  header='[[item.header]]'"
				+ "  order-card='[[item.orderCard]]'"
				+ "  on-card-click='cardClick'>"
				+ "</order-card>");
	}
	
	public static OrderCard create(OrderSummary order) {
		return new OrderCard(order);
	}

	private static OrderStateConverter stateConverter = new OrderStateConverter();

	private boolean recent, inWeek;

	private final OrderSummary order;
	
	public OrderCard(OrderSummary order) {
		this.order = order;
		LocalDate now = LocalDate.now();

	}



	public String getState() {
		return stateConverter.encode(order.getImage());
	}

	public String getFullName() {
		return order.getCustomer().getFullName();
	}

	public List<OrderItem> getItems() {
		return order.getItems();
	}
}