package com.shedin.core.spring;

import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static com.shedin.core.spring.ApplicationContextProvider.getApplicationContext;


public class Main {
	public static void main(String[] args) {
		ApplicationContext context = getApplicationContext();
		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
	}
}
