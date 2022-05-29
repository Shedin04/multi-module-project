package com.shedin.stepdefs;

import com.shedin.dto.response.GetAllBookingsResponse;
import com.shedin.dto.response.GetBookingResponse;
import com.shedin.utility.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

import static com.shedin.constants.PropertyConstants.ALL_BOOKINGS_RESPONSE;
import static com.shedin.constants.PropertyConstants.BOOKING_RESPONSE;
import static com.shedin.requestprovider.BookingRequest.getAllBookings;
import static com.shedin.requestprovider.BookingRequest.getBookingById;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GetBookingStepdefs {

	@Given("^the customer sends request to get all bookings$")
	public void the_customer_sends_request_to_get_all_bookings() {
		Response response = getAllBookings();
		TestContext.saveSharedParameter(ALL_BOOKINGS_RESPONSE, Arrays.asList(response.getBody().as(GetAllBookingsResponse[].class)));
	}

	@And("total bookings size is more than {int}")
	public void total_bookings_size_is_more_than(int expectedSize) {
		List<GetAllBookingsResponse> bookings = (List<GetAllBookingsResponse>) TestContext.getSharedParameter(
				ALL_BOOKINGS_RESPONSE);
		assertTrue(bookings.size() > expectedSize,
				   format("Count of the bookings is less that %s. Actual is %s", expectedSize, bookings.size()));
	}

	@Given("^the customer sends request to get booking with (.*) bookingid$")
	public void the_customer_sends_request_to_get_booking_with_bookingid(String bookingid) {
		Response response = getBookingById(bookingid);
		TestContext.saveSharedParameter(BOOKING_RESPONSE, response.as(GetBookingResponse.class));
	}
}