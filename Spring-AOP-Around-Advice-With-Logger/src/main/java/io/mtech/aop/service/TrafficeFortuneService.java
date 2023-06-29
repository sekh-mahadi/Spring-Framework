package io.mtech.aop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficeFortuneService {
	public String getFortune() {
		// simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// return a fortune

		return "Expect heavy traffice this morning.";
	}
}
