package com.macfu.autoModel.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j(topic = "1e")
@Order(5)
@Component("1")
public class Z1 {

	public Z1() {
		log.debug("order-{}", this.getClass().getAnnotation(Order.class).value());
	}

	@PostConstruct
	public void initMethod() {
		log.debug("annotation init bean z1");
	}
}
