package com.shedin.restfullbooker.helpers;

import com.shedin.apicore.helpers.ConfigurationAPIHelper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;

import static com.shedin.restfullbooker.constants.Endpoints.AUTHENTICATION;
import static com.shedin.restfullbooker.constants.Endpoints.BOOKING;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EndpointsHelper {
	@Autowired
	private ConfigurationAPIHelper configurationAPIHelper;
	private String bookingUrl;
	private String authenticationUrl;

	public String getBookingURL() {
		if (bookingUrl == null) {
			bookingUrl = configurationAPIHelper.getEndpointUrl(BOOKING);
		}
		return bookingUrl;
	}

	public String getAuthenticationUrl() {
		if (authenticationUrl == null) {
			authenticationUrl = configurationAPIHelper.getEndpointUrl(AUTHENTICATION);
		}
		return authenticationUrl;
	}
}