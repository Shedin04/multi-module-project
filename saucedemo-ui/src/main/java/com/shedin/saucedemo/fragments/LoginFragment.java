package com.shedin.saucedemo.fragments;

import com.shedin.guicore.components.AbstractPage;
import com.shedin.saucedemo.pages.HomePage;
import com.shedin.saucedemo.pages.ProductsPage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Lazy
@Component
public class LoginFragment extends AbstractSaucedemoFragment {
	private final By rootElementLocator = By.cssSelector(".login-box");
	private final By usernameInputForm = By.cssSelector("#user-name");
	private final By passwordInputForm = By.cssSelector("#password");
	private final By loginButton = By.cssSelector("#login-button");

	@Autowired
	private HomePage homePage;

	@Autowired
	private ProductsPage productsPage;

	public LoginFragment() {
		setRootElementLocator(rootElementLocator);
	}

	public LoginFragment inputUsername(String username) {
		getRootElement().$(usernameInputForm).sendKeys(username);
		return this;
	}

	public LoginFragment inputPassword(String password) {
		getRootElement().$(passwordInputForm).sendKeys(password);
		return this;
	}

	public AbstractPage clickLoginButton() {
		getRootElement().$(loginButton).click();
		if (isAlertDisplayed()) {
			return homePage;
		}
		return productsPage;
	}
}