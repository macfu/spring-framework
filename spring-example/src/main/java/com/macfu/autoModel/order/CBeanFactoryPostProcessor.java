package com.macfu.autoModel.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Order(7)
@Slf4j(topic = "e")
public class CBeanFactoryPostProcessor extends E implements BeanFactoryPostProcessor, InitializingBean {

	// 实例化顺序，JVM对他的实例化
	public CBeanFactoryPostProcessor() {
		log.debug("==constructor bean c");
	}

	// 把一个对象new出来之后，生命周期的一部分
	// Spring自己调用
	@PostConstruct
	public void initMethod() {
		log.debug("annotation init bean c");
	}


	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		int orderValue = 0;
		if (this.getClass().isAnnotationPresent(Order.class)) {
			Order order = this.getClass().getAnnotation(Order.class);
			orderValue = order.value();
		}
		log.debug("execute postProcessorBeanFactory c order={}", orderValue);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.debug("InitializingBean init method baen c");
	}
}
