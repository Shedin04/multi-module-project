package com.shedin.restfullbooker.requestprovider;

import com.shedin.apicore.helpers.ConfigurationAPIHelper;
import com.shedin.restfullbooker.dto.request.CreateBookingRequest;
import com.shedin.restfullbooker.helpers.EndpointsHelper;
import com.shedin.restfullbooker.helpers.TestContextHelper;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.shedin.apicore.request.BaseRequest.getRequest;
import static com.shedin.apicore.request.BaseRequest.postRequest;
import static org.apache.http.HttpStatus.SC_OK;


@Lazy
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookingRequest {
	@Autowired
	private TestContextHelper helper;
	@Autowired
	private EndpointsHelper endpointsHelper;
	@Autowired
	private ConfigurationAPIHelper configurationAPIHelper;

	public Response getAllBookings() {
		return getRequest(configurationAPIHelper.getBaseURL() + endpointsHelper.getBookingURL(), SC_OK, helper.getToken());
	}

	public Response getBookingById(String bookingId) {
		return getRequest(configurationAPIHelper.getBaseURL() + endpointsHelper.getBookingURL() + bookingId, SC_OK,
						  helper.getToken());
	}

	public Response createNewBooking(CreateBookingRequest createBookingRequest) {
		return postRequest(configurationAPIHelper.getBaseURL() + endpointsHelper.getBookingURL(), SC_OK, createBookingRequest,
						   helper.getToken());
	}
}