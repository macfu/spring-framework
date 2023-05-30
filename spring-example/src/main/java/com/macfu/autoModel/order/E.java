package com.macfu.autoModel.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

@Slf4j(topic = "e")
public class E {

	public void orderList() {
		int orderValue = 0;
		if (this.getClass().isAnnotationPresent(Order.class)) {
			Order order = this.getClass().getAnnotation(Order.class);
			orderValue = order.value();
		}
		log.debug("List Order postProcessorBeanFactory{} order={}", this.getClass().getSimpleName(), orderValue);
	}

}
