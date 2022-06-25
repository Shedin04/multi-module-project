package com.shedin.saucedemo.fragments;

import com.shedin.guicore.components.AbstractFragment;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class AbstractSaucedemoFragment extends AbstractFragment {
	private final By alert = By.cssSelector(".error-message-container.error");

	public boolean isAlertDisplayed() {
		return $(alert).isDisplayed();
	}

	public String getAlertMessage() {
		return $(alert).getText();
	}
}
