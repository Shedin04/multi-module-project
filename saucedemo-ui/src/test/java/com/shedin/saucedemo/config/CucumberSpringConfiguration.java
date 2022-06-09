package com.shedin.saucedemo.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;


@CucumberContextConfiguration
@ContextConfiguration("classpath:spring/gui-context.xml")
public class CucumberSpringConfiguration {
}