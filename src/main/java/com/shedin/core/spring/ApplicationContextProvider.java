package com.shedin.core.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Configuration
public class ApplicationContextProvider {
	private static ApplicationContext context;

	private ApplicationContextProvider() {}

	public static ApplicationContext getApplicationContext() {
		if (context == null) {
			context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		}
		return context;
	}
}