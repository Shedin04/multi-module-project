package com.shedin.restfullbooker.helpers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.shedin.apicore.constants.StringConstants.RequestParameters.COOKIE;


@Lazy
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestHelper {

	@Autowired
	private TestContextHelper helper;

	private final ThreadLocal<HashMap<String, String>> headers = ThreadLocal.withInitial(HashMap::new);

	public Map<String, String> getAuthorisationHeaders() {
		headers.get().put(COOKIE, helper.getToken());
		return headers.get();
	}
}