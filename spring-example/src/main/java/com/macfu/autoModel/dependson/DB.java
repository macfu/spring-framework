package com.macfu.autoModel.dependson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("db")
@Slf4j(topic = "e")
public class DB {

	static {
		log.debug("static db");
	}

	@PostConstruct
	public void initMethod() {
		log.debug("DB initMethod");
	}
}
