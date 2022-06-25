package com.shedin.restfullbooker.helpers;

import com.shedin.apicore.helpers.ConfigurationApiHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.shedin.restfullbooker.constants.EndpointName.AUTHENTICATION;
import static com.shedin.restfullbooker.constants.EndpointName.BOOKING;


@Lazy
@Component
public class EndpointsHelper {
	private final ConfigurationApiHelper configurationAPIHelper;
	private String bookingUrl;
	private String authenticationUrl;

	@Autowired
	private EndpointsHelper(ConfigurationApiHelper configurationAPIHelper) {
		this.configurationAPIHelper = configurationAPIHelper;
	}

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