package com.macfu.autoModel.lookup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("lc")
@Slf4j(topic = "e")
public abstract class LC {

	public void printInfo() {
		LB lb = createb();
		log.debug("lb-[{}]", lb);
		lb = createb();
		log.debug("lb-[{}]", lb);
	}

	public abstract LB createb();
}
