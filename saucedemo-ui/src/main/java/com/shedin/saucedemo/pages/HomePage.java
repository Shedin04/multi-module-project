package com.shedin.saucedemo.pages;

import com.shedin.guicore.utility.ConfigurationHelper;
import com.shedin.saucedemo.fragments.LoginFragment;
import lombok.Getter;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;


@Lazy
@Component
public class HomePage extends AbstractSaucedemoPage {
	private final By loginLogo = By.cssSelector(".login_logo");

	@Autowired
	@Getter
	private LoginFragment loginFragment;

	public HomePage() {
		setPagePath(ConfigurationHelper.getPagePath(getPageName()));
	}

	public boolean isLogoDisplayed() {
		return $(loginLogo).isDisplayed();
	}
}