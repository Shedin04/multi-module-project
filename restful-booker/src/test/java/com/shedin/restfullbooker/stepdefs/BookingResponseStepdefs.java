package com.shedin.restfullbooker.stepdefs;

import com.shedin.restfullbooker.dto.response.GetBookingResponse;
import io.cucumber.java.en.And;

import java.math.BigDecimal;

import static com.shedin.apicore.utility.TestContext.getSharedParameter;
import static com.shedin.restfullbooker.constants.Constants.BOOKING_RESPONSE;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BookingResponseStepdefs {

	@And("^the booking first name is (.*)$")
	public void the_booking_first_name_is(String expectedFirstName) {
		assertEquals(expectedFirstName, ((GetBookingResponse) getSharedParameter(BOOKING_RESPONSE)).getFirstname());
	}

	@And("^the booking last name is (.*)$")
	public void the_booking_last_name_is(String expectedLastName) {
		assertEquals(expectedLastName, ((GetBookingResponse) getSharedParameter(BOOKING_RESPONSE)).getLastname());
	}

	@And("^the booking price is (.*)$")
	public void the_booking_price_is(BigDecimal expectedPrice) {
		assertEquals(expectedPrice,
					 ((GetBookingResponse) getSharedParameter(BOOKING_RESPONSE)).getTotalprice());
	}
}