package com.macfu.autoModel.inside;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class H {

	class J {
		public J(H h) {

		}
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
		configApplicationContext.register(H.class);
		configApplicationContext.register(J.class);
		configApplicationContext.refresh();

		configApplicationContext.getBean(J.class);
	}
}
