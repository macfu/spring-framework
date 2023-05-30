package com.macfu.autoModel.dependson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("da")
@Slf4j(topic = "e")
@DependsOn("db")
public class DA {

	@PostConstruct
	public void initMethod() {
		log.debug("DA initMethod");
	}
}
