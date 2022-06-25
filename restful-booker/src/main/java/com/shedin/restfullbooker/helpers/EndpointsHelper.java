package com.shedin.restfullbooker.helpers;

import com.shedin.apicore.helpers.ConfigurationAPIHelper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.shedin.restfullbooker.constants.EndpointName.AUTHENTICATION;
import static com.shedin.restfullbooker.constants.EndpointName.BOOKING;


@Lazy
@Component
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