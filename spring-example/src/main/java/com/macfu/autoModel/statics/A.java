package com.macfu.autoModel.statics;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "e")
public class A {

	public A() {
		log.debug("default Constructor");
	}

	public A(String s) {
		log.debug("Constructor String static factory method");
	}

	public A(int i) {
		log.debug("Constructor int factory method");
	}

	public A(float f) {
		log.debug("Constructor float supplier");
	}
}
