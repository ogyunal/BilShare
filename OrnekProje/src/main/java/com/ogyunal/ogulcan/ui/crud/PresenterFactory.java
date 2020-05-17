/**
 *
 */
package com.ogyunal.ogulcan.ui.crud;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ogyunal.ogulcan.app.security.CurrentUser;
import com.ogyunal.ogulcan.backend.data.entity.Order;
import com.ogyunal.ogulcan.backend.service.OrderService;
import com.ogyunal.ogulcan.ui.views.storefront.StorefrontView;

@Configuration
public class PresenterFactory {

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public EntityPresenter<Order, StorefrontView> orderEntityPresenter(OrderService crudService, CurrentUser currentUser) {
		return new EntityPresenter<>(crudService, currentUser);
	}

}
