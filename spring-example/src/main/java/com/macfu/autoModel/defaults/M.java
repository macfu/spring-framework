package com.macfu.autoModel.defaults;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "e")
public class M {

	public M() {
		log.debug("default constructor m");
	}

	public M(N n) {
		log.debug("setter N:{}", n);
	}

	private N n;
}
