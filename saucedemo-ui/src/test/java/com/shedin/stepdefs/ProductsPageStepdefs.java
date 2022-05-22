package com.shedin.stepdefs;

import com.shedin.desktop.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.shedin.driver.DriverManager.getCurrentURL;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ProductsPageStepdefs {
	private final ProductsPage productsPage = new ProductsPage();

	@Given("^the 'Products' page is opened$")
	public void the_products_page_is_opened() {
		assertTrue(getCurrentURL().endsWith(productsPage.getPagePath()),
				   "The 'Products' page isn't opened");
	}

	@Then("^the customer sees products containers$")
	public void the_customer_sees_products_containers() {
		assertTrue(productsPage.isProductsContainerDisplayed(), "There is no products container");
	}
}