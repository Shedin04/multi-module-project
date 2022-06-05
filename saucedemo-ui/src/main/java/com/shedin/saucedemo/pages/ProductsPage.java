package com.shedin.saucedemo.pages;

import com.shedin.guicore.components.AbstractPage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;


@Component
public class ProductsPage extends AbstractPage {
	private final String pagePath = "/inventory.html";
	private final By productsContainer = By.cssSelector("#inventory_container");

	public ProductsPage() {
		setPagePath(pagePath);
	}

	public boolean isProductsContainerDisplayed() {
		return $(productsContainer).isDisplayed();
	}
}