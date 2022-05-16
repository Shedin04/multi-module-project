package com.shedin.desktop.fragments;

import com.shedin.components.AbstractFragment;
import com.shedin.components.AbstractPage;
import com.shedin.desktop.pages.HomePage;
import com.shedin.desktop.pages.ProductsPage;
import org.openqa.selenium.By;


public class LoginFragment extends AbstractFragment {

	private final By usernameInputForm = By.cssSelector("#user-name");
	private final By passwordInputForm = By.cssSelector("#password");
	private final By loginButton = By.cssSelector("#login-button");

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
			return new HomePage();
		}
		return new ProductsPage();
	}
}