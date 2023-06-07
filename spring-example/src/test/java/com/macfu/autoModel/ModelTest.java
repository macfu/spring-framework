package com.macfu.autoModel;

import com.macfu.autoModel.config.ModelConfig;
import com.macfu.autoModel.defaults.A;
import com.macfu.autoModel.inject.F;
import com.macfu.autoModel.inject.I;
import com.macfu.autoModel.lookup.LC;
import com.macfu.autoModel.order.E;
import com.macfu.autoModel.order.T;
import com.macfu.autoModel.statics.SupplierFactory;
import com.macfu.autoModel.util.ModelBeanFactoryPostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * 测试注入模型
 */
@Slf4j(topic = "e")
public class ModelTest {

	/**
	 * 测试注入模型对bean的影响
	 * 包括实例化，或者一些高级特性
	 */
	@Test
	public void defaultModel() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ModelConfig.class);
		// 改变了A的注入模型 Spring当中的注入模型很重要
		context.register(ModelBeanFactoryPostProcessor.class);
		context.refresh();
	}

	/**
	 * 测试@Autowired的注入基本原理
	 * 先type继而name
	 * 如果有多个在根据name
	 */
	@Test
	public void autowiredModel() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.macfu.autoModel.inject");
		context.refresh();

		I i = context.getBean(F.class).getI();
		log.debug("i == [[]]", i);
	}

	/**
	 * 测试@Order注解的功能
	 * 不会影响bean的扫描顺序
	 * 具体需要看Spring源码内部有没有对他做解析
	 */
	@Test
	public void orderModel() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.macfu.autoModel.order");
		context.refresh();
		List<E> beanFactoryPostProcessor = context.getBean(T.class).getBeanFactoryPostProcessor();
		for (E e : beanFactoryPostProcessor) {
			e.orderList();
		}
	}

	/**
	 * 测试工厂方法实例工厂方法，supplier
	 * Spring优先选用supplier
	 */
	@Test
	public void staticsModel() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ObjectFactory.class);
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(A.class);

		beanDefinition.setInstanceSupplier(SupplierFactory::getObject);

		beanDefinition.setFactoryBeanName("objectFactory");
		beanDefinition.setFactoryMethodName("instanceObject");

		context.registerBeanDefinition("a", beanDefinition);
		context.refresh();
	}

	@Test
	public void lookupModel() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.macfu.autoModel.lookup");
		context.refresh();
		context.getBean(LC.class).printInfo();
	}

	/**
	 * 测试dependsOn作用
	 */
	@Test
	public void dependsOnModel() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.macfu.autoModel.dependsOn");
		context.refresh();
	}


}
