package com.shedin.desktop.pages;

import com.shedin.components.AbstractPage;
import org.openqa.selenium.WebDriver;


public class HomePage extends AbstractPage {
	private final String pageURL = "https://www.saucedemo.com/";

	public HomePage(WebDriver driver) {
		super(driver);
		setPageURL(pageURL);
	}
}