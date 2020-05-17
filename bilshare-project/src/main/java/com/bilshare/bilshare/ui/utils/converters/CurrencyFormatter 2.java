package com.bilshare.bilshare.ui.utils.converters;

import com.vaadin.flow.templatemodel.ModelEncoder;
import com.bilshare.bilshare.ui.dataproviders.DataProviderUtil;
import com.bilshare.bilshare.ui.utils.FormattingUtils;

public class CurrencyFormatter implements ModelEncoder<Integer, String> {

	@Override
	public String encode(Integer modelValue) {
		return DataProviderUtil.convertIfNotNull(modelValue, FormattingUtils::formatAsCurrency);
	}

	@Override
	public Integer decode(String presentationValue) {
		throw new UnsupportedOperationException();
	}
}
