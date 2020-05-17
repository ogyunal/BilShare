package com.bilshare.bilshare.backend.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


import com.bilshare.bilshare.backend.data.OrderImage;
import com.bilshare.bilshare.backend.data.entity.Order;
import com.bilshare.bilshare.backend.data.entity.OrderSummary;
import com.bilshare.bilshare.backend.data.entity.User;
import com.bilshare.bilshare.backend.repositories.OrderRepository;

@Service
public class OrderService implements CrudService<Order> {

	private final OrderRepository orderRepository;

	@Autowired
	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	private static final Set<OrderImage> notAvailableStates = Collections.unmodifiableSet(
			EnumSet.complementOf(EnumSet.of(OrderImage.DELIVERED, OrderImage.READY, OrderImage.CANCELLED)));

	@Transactional(rollbackOn = Exception.class)
	public Order saveOrder(User currentUser, Long id, BiConsumer<User, Order> orderFiller) {
		Order order;
		if (id == null) {
			order = new Order(currentUser);
		} else {
			order = load(id);
		}
		orderFiller.accept(currentUser, order);
		return orderRepository.save(order);
	}

	@Transactional(rollbackOn = Exception.class)
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	@Transactional(rollbackOn = Exception.class)
	public Order addComment(User currentUser, Order order, String comment) {
		return orderRepository.save(order);
	}

	public Page<Order> findAnyMatchingAfterDueDate(Optional<String> optionalFilter,
			Optional<LocalDate> optionalFilterDate, Pageable pageable) {
				return orderRepository.findByCustomerFullNameContainingIgnoreCase(optionalFilter.get(), pageable);

		}


	private List<Number> flattenAndReplaceMissingWithNull(int length, List<Object[]> list) {
		List<Number> counts = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			counts.add(null);
		}

		for (Object[] result : list) {
			counts.set((Integer) result[0] - 1, (Number) result[1]);
		}
		return counts;
	}

	@Override
	public JpaRepository<Order, Long> getRepository() {
		return orderRepository;
	}

	@Override
	@Transactional
	public Order createNew(User currentUser) {
		Order order = new Order(currentUser);
		return order;
	}

}
