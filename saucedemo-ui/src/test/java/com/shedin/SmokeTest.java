package com.shedin;

import com.shedin.desktop.pages.HomePage;

import static com.shedin.driver.DriverManager.getDriver;


class SmokeTest {

	public static void main(String[] args) {
		HomePage homePage = new HomePage(getDriver());
		homePage.openPage();
	}
}