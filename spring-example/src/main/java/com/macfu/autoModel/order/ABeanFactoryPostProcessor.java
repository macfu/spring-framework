package com.macfu.autoModel.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Order(6)
@Slf4j(topic = "e")
public class ABeanFactoryPostProcessor extends E implements BeanFactoryPostProcessor {

	// 实例化顺序，JVM对他的实例化
	public ABeanFactoryPostProcessor() {
		log.debug("==constructor");
	}

	// 把一个对象new出来之后，生命周期的一部分
	// Spring自己调用
	@PostConstruct
	public void initMethod() {
		log.debug("annotation init bean a");
	}


	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		int orderValue = 0;
		if (this.getClass().isAnnotationPresent(Order.class)) {
			Order order = this.getClass().getAnnotation(Order.class);
			orderValue = order.value();
		}
		log.debug("execute postProcessorBeanFactory a order={}", orderValue);
	}
}
