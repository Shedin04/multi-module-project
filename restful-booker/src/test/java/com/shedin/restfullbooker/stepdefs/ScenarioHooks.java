package com.shedin.restfullbooker.stepdefs;

import com.shedin.restfullbooker.dto.response.AuthorizationCredsResponse;
import com.shedin.apicore.utility.TestContext;
import io.cucumber.java.Before;

import static com.shedin.apicore.constants.StringConstants.TOKEN;
import static com.shedin.restfullbooker.requestprovider.TokenRequest.getAuthorizationToken;


public class ScenarioHooks {

	@Before(value = "@GetToken", order = 1)
	public void getToken() {
		TestContext.saveSharedParameter(TOKEN, getAuthorizationToken().as(AuthorizationCredsResponse.class).getToken());
	}
}