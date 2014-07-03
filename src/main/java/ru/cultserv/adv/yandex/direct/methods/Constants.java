package ru.cultserv.adv.yandex.direct.methods;

import com.google.common.base.Function;

/**
 * @author Alexandr Kolosov
 * @since 7/3/14
 */
class Constants {

	public static final Function<Object[], Object> SINGLE_PARAM_CONVERTER = new Function<Object[], Object>() {
		@Override
		public Object apply(Object[] input) {
			return input.length == 1 ? input[0] : input;
		}
	};

	public static final Function<Object[], Object> EMPTY_PARAM_CONVERTER = new Function<Object[], Object>() {
		@Override
		public Object apply(Object[] input) {
			return ((Object[]) input[0]).length == 0 ? null : input;
		}
	};
	
}