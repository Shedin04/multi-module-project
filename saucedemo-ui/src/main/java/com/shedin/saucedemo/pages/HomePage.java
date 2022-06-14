package com.shedin.saucedemo.pages;

import com.shedin.guicore.components.AbstractPage;
import com.shedin.saucedemo.fragments.LoginFragment;
import lombok.Getter;
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

	@Autowired @Getter
	private LoginFragment loginFragment;

	public HomePage() {
		setPagePath(HOME_PAGE_PATH);
	}

	public boolean isLogoDisplayed() {
		return $(loginLogo).isDisplayed();
	}
}