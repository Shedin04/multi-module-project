package com.shedin.stepdefs;

import com.shedin.dto.response.GetBookingResponse;
import com.shedin.utility.TestContext;
import io.cucumber.java.en.And;

import static com.shedin.constants.PropertyConstants.BOOKING_RESPONSE;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BookingResponseStepdefs {
	private static final GetBookingResponse response = (GetBookingResponse) TestContext.getSharedParameter(BOOKING_RESPONSE);

	@And("^the booking first name is (.*)$")
	public void the_booking_first_name_is(String expectedFirstName) {
		assertEquals(expectedFirstName, response.getFirstname());
	}

	@And("^the booking last name is (.*)$")
	public void the_booking_last_name_is(String expectedLastName) {
		assertEquals(expectedLastName, response.getLastname());
	}

	@And("^the booking price is (.*)$")
	public void the_booking_price_is(int expectedPrice) {
		assertEquals(expectedPrice, response.getTotalprice());
	}
}
