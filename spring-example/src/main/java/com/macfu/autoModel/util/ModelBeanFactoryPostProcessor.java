package com.macfu.autoModel.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

@Slf4j(topic = "e")
public class ModelBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		AbstractBeanDefinition m = (AbstractBeanDefinition) beanFactory.getBeanDefinition("m");
		log.debug("model:{}", m.getAutowireMode());
		m.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
	}
}
