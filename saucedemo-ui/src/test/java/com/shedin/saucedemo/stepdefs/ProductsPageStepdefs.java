package com.shedin.saucedemo.stepdefs;

import com.shedin.saucedemo.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static com.shedin.guicore.driver.DriverManager.getCurrentURL;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ProductsPageStepdefs {
	@Autowired
	private ProductsPage productsPage;

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