package com.bilshare.bilshare.ui.dataproviders;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;

import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.QuerySortOrderBuilder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.bilshare.bilshare.backend.data.entity.Order;
import com.bilshare.bilshare.backend.service.OrderService;
import com.bilshare.bilshare.ui.utils.BilShareConst;

/**
 * A pageable order data provider.
 */
@SpringComponent
@UIScope
public class OrdersGridDataProvider extends FilterablePageableDataProvider<Order, OrdersGridDataProvider.OrderFilter> {

	@Override
	protected int sizeInBackEnd(Query<Order, OrderFilter> query) {
		return 0;
	}

	public static class OrderFilter implements Serializable {
		private String filter;
		private boolean showPrevious;

		public String getFilter() {
			return filter;
		}

		public boolean isShowPrevious() {
			return showPrevious;
		}

		public OrderFilter(String filter, boolean showPrevious) {
			this.filter = filter;
			this.showPrevious = showPrevious;
		}

		public static OrderFilter getEmptyFilter() {
			return new OrderFilter("", false);
		}
	}

	private final OrderService orderService;
	private List<QuerySortOrder> defaultSortOrders;
	private Consumer<Page<Order>> pageObserver;
	
	@Autowired
	public OrdersGridDataProvider(OrderService orderService) {
		this.orderService = orderService;
		setSortOrders(BilShareConst.DEFAULT_SORT_DIRECTION, BilShareConst.ORDER_SORT_FIELDS);
	}

	private void setSortOrders(Sort.Direction direction, String[] properties) {
		QuerySortOrderBuilder builder = new QuerySortOrderBuilder();
		for (String property : properties) {
			if (direction.isAscending()) {
				builder.thenAsc(property);
			} else {
				builder.thenDesc(property);
			}
		}
		defaultSortOrders = builder.build();
	}

	@Override
	protected Page<Order> fetchFromBackEnd(Query<Order, OrderFilter> query, Pageable pageable) {
		OrderFilter filter = query.getFilter().orElse(OrderFilter.getEmptyFilter());
		Page<Order> page = orderService.findAnyMatchingAfterDueDate(Optional.ofNullable(filter.getFilter()),
				getFilterDate(filter.isShowPrevious()), pageable);
		if (pageObserver != null) {
			pageObserver.accept(page);
		}
		return page;
	}

	@Override
	protected List<QuerySortOrder> getDefaultSortOrders() {
		return defaultSortOrders;
	}

	private Optional<LocalDate> getFilterDate(boolean showPrevious) {
		if (showPrevious) {
			return Optional.empty();
		}

		return Optional.of(LocalDate.now().minusDays(1));
	}

	public void setPageObserver(Consumer<Page<Order>> pageObserver) {
		this.pageObserver = pageObserver;
	}

	@Override
	public Object getId(Order item) {
		return item.getId();
	}
}
