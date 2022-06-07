package com.shedin.restfullbooker.requestprovider;

import com.shedin.restfullbooker.dto.request.CreateBookingRequest;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.shedin.restfullbooker.constants.Endpoints.BOOKING;
import static com.shedin.apicore.request.BaseRequest.getRequest;
import static com.shedin.apicore.request.BaseRequest.postRequest;
import static com.shedin.apicore.utility.ConfigurationAPIHelper.getBaseURL;
import static com.shedin.apicore.utility.TestContext.getToken;
import static org.apache.http.HttpStatus.SC_OK;


@Lazy
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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