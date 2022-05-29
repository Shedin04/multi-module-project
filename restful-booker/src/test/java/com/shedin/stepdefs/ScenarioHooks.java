package com.shedin.stepdefs;

import com.shedin.dto.response.AuthorizationCredsResponse;
import com.shedin.utility.TestContext;
import io.cucumber.java.Before;

import static com.shedin.constants.StringConstants.TOKEN;
import static com.shedin.requestprovider.TokenRequest.getAuthorizationToken;


public class ScenarioHooks {

	@Before(value = "@GetToken", order = 1)
	public void getToken() {
		TestContext.saveSharedParameter(TOKEN, getAuthorizationToken().as(AuthorizationCredsResponse.class).getToken());
	}
}