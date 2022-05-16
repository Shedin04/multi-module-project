package com.shedin;

import com.shedin.desktop.constants.Creds;
import com.shedin.desktop.pages.HomePage;
import com.shedin.desktop.pages.ProductsPage;
import com.shedin.driver.DriverManager;
import org.junit.jupiter.api.*;

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
				.inputUsername(Creds.STANDARD_ACCOUNT.LOGIN.get())
				.inputPassword(Creds.STANDARD_ACCOUNT.PASSWORD.get())
				.clickLoginButton();
		assertTrue(productsPage.isProductsContainerDisplayed(), "There is no products container");
	}
}