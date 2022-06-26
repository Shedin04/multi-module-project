package com.shedin.restfullbooker.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.shedin.apicore.constants.StringConstants.RequestParameters.COOKIE;


@Lazy
@Component
public class RequestHelper {
	private final Map<String, String> headers = new ConcurrentHashMap<>();
	private final TestContextHelper helper;

	@Autowired
	private RequestHelper(TestContextHelper helper) {
		this.helper = helper;
	}

	public Map<String, String> getAuthorisationHeaders() {
		if (headers.isEmpty()) {
			headers.put(COOKIE, helper.getToken());
		}
		return headers;
	}
}