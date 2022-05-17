package com.shedin;

import com.shedin.desktop.constants.Credentials;
import com.shedin.desktop.pages.HomePage;
import com.shedin.desktop.pages.ProductsPage;
import com.shedin.driver.DriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class SmokeTest {

	@BeforeEach
	void setUpDriver() {
		DriverManager.setDriver();
	}

	@AfterEach
	void closeDriver() {
		DriverManager.closeDriver();
	}

	@Test
	void positiveTest() {
		HomePage homePage = new HomePage();
		homePage.openPage();
		assertTrue(homePage.isLogoDisplayed(), "There is no logo");
		assertTrue(homePage.getLoginFragment().isDisplayed(), "There is no login fragment");
		ProductsPage productsPage = (ProductsPage) homePage.getLoginFragment()
				.inputUsername(Credentials.STANDARD_ACCOUNT.LOGIN.get())
				.inputPassword(Credentials.STANDARD_ACCOUNT.PASSWORD.get())
				.clickLoginButton();
		assertTrue(productsPage.isProductsContainerDisplayed(), "There is no products container");
	}

	@Test
	void negativeTest() {
		HomePage homePage = new HomePage();
		homePage.openPage();
		assertTrue(homePage.isLogoDisplayed(), "There is no logo");
		assertTrue(homePage.getLoginFragment().isDisplayed(), "There is no login fragment");
		homePage = (HomePage) homePage.getLoginFragment()
				.inputUsername(Credentials.STANDARD_ACCOUNT.LOGIN.get())
				.inputPassword("wrong" + Credentials.STANDARD_ACCOUNT.PASSWORD.get())
				.clickLoginButton();
		assertTrue(homePage.getLoginFragment().isAlertDisplayed(), "There is no alert message");
	}
}