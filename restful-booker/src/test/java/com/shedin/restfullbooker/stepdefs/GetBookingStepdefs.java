package com.shedin.restfullbooker.stepdefs;

import com.shedin.restfullbooker.dto.response.CreateBookingResponse;
import com.shedin.restfullbooker.requestprovider.BookingRequest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

import static com.shedin.apicore.utility.TestContext.getSharedParameter;
import static com.shedin.restfullbooker.constants.Constants.Values.ALL_BOOKINGS_RESPONSE;
import static com.shedin.restfullbooker.constants.Constants.Values.NEW_BOOKING;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GetBookingStepdefs {
	@Autowired
	private BookingRequest bookingRequest;

	@Given("^the customer sends request to get all bookings$")
	public void the_customer_sends_request_to_get_all_bookings() {
		Response response = bookingRequest.getAllBookings();
		assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Incorrect status code");
	}

	@And("total bookings size is more than {int}")
	public void total_bookings_size_is_more_than(int expectedSize) {
		List<?> bookings = (List<?>) getSharedParameter(ALL_BOOKINGS_RESPONSE);
		assertTrue(bookings.size() > expectedSize,
				   format("Count of the bookings is less that %s. Actual is %s", expectedSize, bookings.size()));
	}

	@Given("^the customer sends request to get booking with (.*) bookingid$")
	public void the_customer_sends_request_to_get_booking_with_bookingid(String bookingid) {
		Response response = bookingRequest.getBookingById(bookingid);
		assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Incorrect status code");
	}

	@When("^the customer tries to get new-created bookingid$")
	public void the_customer_saves_a_new_bookingid() {
		BigInteger bookingid = ((CreateBookingResponse) getSharedParameter(NEW_BOOKING)).getBookingid();
		the_customer_sends_request_to_get_booking_with_bookingid(bookingid.toString());
	}
}