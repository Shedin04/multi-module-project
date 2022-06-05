package com.shedin.saucedemo.pages;

import com.shedin.guicore.components.AbstractPage;
import com.shedin.saucedemo.fragments.LoginFragment;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;


@Component
public class HomePage extends AbstractPage {
	private final String pagePath = "/";

	private final By loginLogo = By.cssSelector(".login_logo");
	private final By loginBox = By.cssSelector(".login-box");

	@Autowired
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