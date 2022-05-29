package com.shedin.requestprovider;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static com.shedin.constants.Endpoints.BOOKING;
import static com.shedin.request.BaseRequest.getRequest;
import static com.shedin.utility.ConfigurationAPIHelper.getBaseURL;
import static com.shedin.utility.TestContext.getToken;


public class BookingRequest {

	private BookingRequest() {}

	public static Response getAllBookings() {
		return getRequest(getBaseURL() + BOOKING, HttpStatus.SC_OK, getToken());
	}

	public static Response getBookingById(String bookingId) {
		return getRequest(getBaseURL() + BOOKING + bookingId, HttpStatus.SC_OK, getToken());
	}
}