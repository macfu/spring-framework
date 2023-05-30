package com.macfu.autoModel;

import com.macfu.autoModel.config.ModelConfig;
import com.macfu.autoModel.util.ModelBeanFactoryPostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

}
