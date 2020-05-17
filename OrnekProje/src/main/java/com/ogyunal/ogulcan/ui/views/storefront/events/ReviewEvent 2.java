package com.ogyunal.ogulcan.ui.views.storefront.events;

import com.vaadin.flow.component.ComponentEvent;
import com.ogyunal.ogulcan.ui.views.orderedit.OrderEditor;

public class ReviewEvent extends ComponentEvent<OrderEditor> {

	public ReviewEvent(OrderEditor component) {
		super(component, false);
	}
}