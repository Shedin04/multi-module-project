package com.shedin.saucedemo.pages;

import com.shedin.guicore.components.AbstractPage;
import com.shedin.guicore.utility.ConfigurationHelper;


public abstract class AbstractSaucedemoPage extends AbstractPage {

	protected void setPagePath() {
		super.setPagePath(ConfigurationHelper.getPagePath(getPageName()));
	}

	public String getPageName() {
		return this.getClass().getSimpleName();
	}
}