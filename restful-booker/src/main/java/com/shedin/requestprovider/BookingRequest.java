package com.shedin.requestprovider;

import com.shedin.dto.request.CreateBookingRequest;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

import static com.shedin.constants.Endpoints.BOOKING;
import static com.shedin.request.BaseRequest.getRequest;
import static com.shedin.request.BaseRequest.postRequest;
import static com.shedin.utility.ConfigurationAPIHelper.getBaseURL;
import static com.shedin.utility.TestContext.getToken;
import static org.apache.http.HttpStatus.SC_OK;


@UtilityClass
public class BookingRequest {

	public static Response getAllBookings() {
		return getRequest(getBaseURL() + BOOKING, SC_OK, getToken());
	}

	public static Response getBookingById(String bookingId) {
		return getRequest(getBaseURL() + BOOKING + bookingId, SC_OK, getToken());
	}

	public static Response createNewBooking(CreateBookingRequest createBookingRequest) {
		return postRequest(getBaseURL() + BOOKING, SC_OK, createBookingRequest, getToken());
	}
}