package com.shedin.restfullbooker.requestprovider;

import com.shedin.apicore.utility.ConfigurationAPIHelper;
import com.shedin.restfullbooker.dto.request.CreateBookingRequest;
import io.restassured.response.Response;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.shedin.restfullbooker.constants.Endpoints.BOOKING;
import static com.shedin.apicore.request.BaseRequest.getRequest;
import static com.shedin.apicore.request.BaseRequest.postRequest;
import static com.shedin.apicore.utility.TestContext.getToken;
import static org.apache.http.HttpStatus.SC_OK;


@Lazy
@Component
@NoArgsConstructor
public class BookingRequest {
	@Autowired
	private ConfigurationAPIHelper configurationAPIHelper;

	public Response getAllBookings() {
		return getRequest(configurationAPIHelper.getBaseURL() + BOOKING, SC_OK, getToken());
	}

	public Response getBookingById(String bookingId) {
		return getRequest(configurationAPIHelper.getBaseURL() + BOOKING + bookingId, SC_OK, getToken());
	}

	public Response createNewBooking(CreateBookingRequest createBookingRequest) {
		return postRequest(configurationAPIHelper.getBaseURL() + BOOKING, SC_OK, createBookingRequest, getToken());
	}
}