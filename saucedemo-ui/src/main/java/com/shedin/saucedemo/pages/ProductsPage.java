package com.shedin.saucedemo.pages;

import org.openqa.selenium.By;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;


@Lazy
@Component
public class ProductsPage extends AbstractSaucedemoPage {
	private final By productsContainer = By.cssSelector("#inventory_container");

	public ProductsPage() {
		setPagePath();
	}

	public boolean isProductsContainerDisplayed() {
		return $(productsContainer).isDisplayed();
	}
}