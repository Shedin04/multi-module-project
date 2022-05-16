package com.shedin.desktop.pages;

import com.shedin.components.AbstractPage;
import com.shedin.desktop.fragments.LoginFragment;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class HomePage extends AbstractPage {
	private final String pagePath = "/";

	private final By loginLogo = By.cssSelector(".login_logo");
	private final By loginBox = By.cssSelector(".login-box");

	private LoginFragment loginFragment;

	public HomePage() {
		setPagePath(pagePath);
	}

	public boolean isLogoDisplayed() {
		return $(loginLogo).isDisplayed();
	}

	public LoginFragment getLoginFragment() {
		if (loginFragment == null) {
			loginFragment = new LoginFragment();
			loginFragment.setRootElement($(loginBox));
		}
		return loginFragment;
	}
}