package com.bilshare.bilshare.ui.utils.converters;

import static com.bilshare.bilshare.ui.dataproviders.DataProviderUtil.convertIfNotNull;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.vaadin.flow.templatemodel.ModelEncoder;
import com.bilshare.bilshare.backend.data.OrderImage;

public class OrderStateConverter implements ModelEncoder<OrderImage, String> {

	private Map<String, OrderImage> values;

	public OrderStateConverter() {
		values = Arrays.stream(OrderImage.values())
				.collect(Collectors.toMap(OrderImage::toString, Function.identity()));
	}

	@Override
	public OrderImage decode(String presentationValue) {
		return convertIfNotNull(presentationValue, values::get);
	}

	@Override
	public String encode(OrderImage modelValue) {
		return convertIfNotNull(modelValue, OrderImage::toString);
	}

}
