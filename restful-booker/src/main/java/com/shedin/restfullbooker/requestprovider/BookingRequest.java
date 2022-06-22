package com.shedin.restfullbooker.requestprovider;

import com.shedin.apicore.helpers.ConfigurationAPIHelper;
import com.shedin.restfullbooker.dto.request.CreateBookingRequest;
import com.shedin.restfullbooker.helpers.EndpointsHelper;
import com.shedin.restfullbooker.helpers.RequestHelper;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.shedin.apicore.request.BaseRequest.getRequest;
import static com.shedin.apicore.request.BaseRequest.postRequest;


@Lazy
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookingRequest {
	@Autowired
	private RequestHelper helper;
	@Autowired
	private EndpointsHelper endpointsHelper;
	@Autowired
	private ConfigurationAPIHelper configurationAPIHelper;

	public Response getAllBookings() {
		return getRequest(configurationAPIHelper.getBaseURL() + endpointsHelper.getBookingURL(),
						  helper.getAuthorisationHeaders());
	}

	public Response getBookingById(String bookingId) {
		return getRequest(configurationAPIHelper.getBaseURL() + endpointsHelper.getBookingURL() + bookingId,
						  helper.getAuthorisationHeaders());
	}

	public Response createNewBooking(CreateBookingRequest createBookingRequest) {
		return postRequest(configurationAPIHelper.getBaseURL() + endpointsHelper.getBookingURL(), createBookingRequest,
						   helper.getAuthorisationHeaders());
	}
}