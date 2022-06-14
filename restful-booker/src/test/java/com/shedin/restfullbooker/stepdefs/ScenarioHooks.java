package com.shedin.restfullbooker.stepdefs;

import com.shedin.restfullbooker.dto.response.AuthorizationCredsResponse;
import com.shedin.restfullbooker.requestprovider.TokenRequest;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

import static com.shedin.apicore.constants.StringConstants.TOKEN;
import static com.shedin.apicore.utility.TestContext.saveSharedParameter;


public class ScenarioHooks {
	@Autowired
	private TokenRequest tokenRequest;

	@Before(value = "@GetToken", order = 1)
	public void getToken() {
		saveSharedParameter(TOKEN,
							tokenRequest.getAuthorizationToken().as(AuthorizationCredsResponse.class).getToken());
	}
}