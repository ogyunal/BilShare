package com.bilshare.bilshare.ui.views.admin.products;

import static com.bilshare.bilshare.ui.dataproviders.DataProviderUtil.convertIfNotNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;
import com.bilshare.bilshare.ui.utils.FormattingUtils;

class PriceConverter implements Converter<String, Integer> {

	private final DecimalFormat df = FormattingUtils.getUiPriceFormatter();

	@Override
	public Result<Integer> convertToModel(String presentationValue, ValueContext valueContext) {
		try {
			return Result.ok((int) Math.round(df.parse(presentationValue).doubleValue() * 100));
		} catch (ParseException e) {
			return Result.error("Invalid value");
		}
	}

	@Override
	public String convertToPresentation(Integer modelValue, ValueContext valueContext) {
		return convertIfNotNull(modelValue, i -> df.format(BigDecimal.valueOf(i, 2)), () -> "");
	}
}