package com.shedin.saucedemo.stepdefs;

import com.shedin.saucedemo.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static com.shedin.guicore.constants.StringConstants.BasicOperators.IS;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class HomePageStepdefs {
	@Autowired
	private HomePage homePage;

	@Given("^the customer opens the 'Home' page$|^the guest opens the 'Home' page$")
	public void the_customer_opens_the_home_page() {
		homePage.openPage();
	}

	@And("the customer {string} on the 'Home' page")
	public void the_customer_is_on_the_home_page(String displayed) {
		assertEquals(displayed.equals(IS), homePage.isLogoDisplayed(),
					 format("The 'Home' page logo {%s} displayed", displayed));
	}

	@And("^the login fragment (is|is not) displayed$")
	public void the_login_fragment_is_displayed(String displayed) {
		assertEquals(displayed.equals(IS), homePage.getLoginFragment().isDisplayed(), "There is no 'Login' fragment");
	}

	@When("^the customer inputs '(.*)' and '(.*)' in the login input form$")
	public void the_customer_inputs_login_and_password_in_the_login_input_form(String login, String password) {
		homePage.getLoginFragment().inputUsername(login).inputPassword(password);
	}

	@And("^the customer clicks the 'login' button$")
	public void the_customer_clicks_the_login_button() {
		homePage.getLoginFragment().clickLoginButton();
	}

	@And("^the '(.*)' alert message is displayed$")
	public void the_alert_message_is_displayed(String expectedMessage) {
		assertEquals(expectedMessage, homePage.getLoginFragment().getAlertMessage(), "Invalid alert message");
	}
}