package com.shedin.saucedemo.pages;

import com.shedin.guicore.components.AbstractPage;
import com.shedin.saucedemo.fragments.LoginFragment;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static com.shedin.saucedemo.constants.PagePaths.HOME_PAGE_PATH;


@Lazy
@Component
public class HomePage extends AbstractPage {
	private final By loginLogo = By.cssSelector(".login_logo");
	private final By loginBox = By.cssSelector(".login-box");

	private LoginFragment loginFragment;

	public HomePage() {
		setPagePath(HOME_PAGE_PATH);
	}

	public boolean isLogoDisplayed() {
		return $(loginLogo).isDisplayed();
	}

	@Autowired
	public LoginFragment getLoginFragment() {
		if (loginFragment == null) {
			loginFragment = new LoginFragment();
			loginFragment.setRootElement($(loginBox));
		}
		return loginFragment;
	}
}