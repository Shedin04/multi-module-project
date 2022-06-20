package com.shedin.saucedemo.pages;

import com.shedin.guicore.components.AbstractPage;


public class AbstractSaucedemoPage extends AbstractPage {

	public String getPageName() {
		return this.getClass().getSimpleName();
	}
}