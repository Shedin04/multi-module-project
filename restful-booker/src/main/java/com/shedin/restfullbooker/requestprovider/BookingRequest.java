package com.shedin.restfullbooker.requestprovider;

import com.shedin.apicore.helpers.ConfigurationApiHelper;
import com.shedin.restfullbooker.dto.request.CreateBookingRequest;
import com.shedin.restfullbooker.dto.response.CreateBookingResponse;
import com.shedin.restfullbooker.dto.response.GetAllBookingsResponse;
import com.shedin.restfullbooker.dto.response.GetBookingResponse;
import com.shedin.restfullbooker.helpers.EndpointsHelper;
import com.shedin.restfullbooker.helpers.RequestHelper;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.shedin.apicore.request.BaseRequest.getRequest;
import static com.shedin.apicore.request.BaseRequest.postRequest;
import static com.shedin.apicore.utility.TestContext.saveSharedParameter;
import static com.shedin.restfullbooker.constants.Constants.Values.ALL_BOOKINGS_RESPONSE;
import static com.shedin.restfullbooker.constants.Constants.Values.BOOKING_RESPONSE;
import static com.shedin.restfullbooker.constants.Constants.Values.NEW_BOOKING;


@Lazy
@Component
public class BookingRequest {
	private final RequestHelper helper;
	private final EndpointsHelper endpointsHelper;
	private final ConfigurationApiHelper configurationAPIHelper;

	@Autowired
	private BookingRequest(RequestHelper helper, EndpointsHelper endpointsHelper, ConfigurationApiHelper configurationAPIHelper) {
		this.helper = helper;
		this.endpointsHelper = endpointsHelper;
		this.configurationAPIHelper = configurationAPIHelper;
	}

	public Response getAllBookings() {
		Response response = getRequest(configurationAPIHelper.getBaseURL() + endpointsHelper.getBookingURL(),
									   helper.getAuthorisationHeaders());
		saveSharedParameter(ALL_BOOKINGS_RESPONSE,
							Arrays.asList(response.getBody().as(GetAllBookingsResponse[].class)));
		return response;
	}

	public Response getBookingById(String bookingId) {
		Response response = getRequest(configurationAPIHelper.getBaseURL() + endpointsHelper.getBookingURL() + bookingId,
									   helper.getAuthorisationHeaders());
		saveSharedParameter(BOOKING_RESPONSE, response.as(GetBookingResponse.class));
		return response;
	}

	public Response createNewBooking(CreateBookingRequest createBookingRequest) {
		Response response = postRequest(configurationAPIHelper.getBaseURL() + endpointsHelper.getBookingURL(),
										createBookingRequest,
										helper.getAuthorisationHeaders());
		saveSharedParameter(NEW_BOOKING, response.as(CreateBookingResponse.class));
		return response;
	}
}