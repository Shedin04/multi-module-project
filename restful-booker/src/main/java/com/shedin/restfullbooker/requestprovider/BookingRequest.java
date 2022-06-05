package com.shedin.restfullbooker.requestprovider;

import com.shedin.restfullbooker.dto.request.CreateBookingRequest;
import io.restassured.response.Response;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

import static com.shedin.restfullbooker.constants.Endpoints.BOOKING;
import static com.shedin.apicore.request.BaseRequest.getRequest;
import static com.shedin.apicore.request.BaseRequest.postRequest;
import static com.shedin.apicore.utility.ConfigurationAPIHelper.getBaseURL;
import static com.shedin.apicore.utility.TestContext.getToken;
import static org.apache.http.HttpStatus.SC_OK;


@Component
@NoArgsConstructor
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