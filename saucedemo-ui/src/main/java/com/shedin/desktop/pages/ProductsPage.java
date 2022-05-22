package com.shedin.desktop.pages;

import com.shedin.components.AbstractPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


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