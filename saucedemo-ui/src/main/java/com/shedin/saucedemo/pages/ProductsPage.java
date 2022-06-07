package com.shedin.saucedemo.pages;

import com.shedin.guicore.components.AbstractPage;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static com.shedin.saucedemo.constants.PagePaths.PRODUCTS_PAGE_PATH;


@Lazy
@Component
public class ProductsPage extends AbstractPage {

	private final By productsContainer = By.cssSelector("#inventory_container");

	public ProductsPage() {
		setPagePath(PRODUCTS_PAGE_PATH);
	}

	public boolean isProductsContainerDisplayed() {
		return $(productsContainer).isDisplayed();
	}
}