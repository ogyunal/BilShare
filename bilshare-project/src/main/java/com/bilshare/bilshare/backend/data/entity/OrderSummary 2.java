package com.bilshare.bilshare.backend.data.entity;

import java.util.List;

import com.bilshare.bilshare.backend.data.OrderImage;

public interface OrderSummary {
	Long getId();

	OrderImage getImage();

	Customer getCustomer();

	List<OrderItem> getItems();


}
