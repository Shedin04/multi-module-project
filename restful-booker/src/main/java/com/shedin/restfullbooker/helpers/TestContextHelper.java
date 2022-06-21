package com.shedin.restfullbooker.helpers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

import static com.shedin.apicore.constants.StringConstants.RequestParameters.TOKEN;
import static com.shedin.apicore.utility.TestContext.getSharedParameter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestContextHelper {
	private String savedToken;

	public String getToken() {
		if (savedToken == null) {
			savedToken = String.valueOf(getSharedParameter(TOKEN));
		}
		return savedToken;
	}
}