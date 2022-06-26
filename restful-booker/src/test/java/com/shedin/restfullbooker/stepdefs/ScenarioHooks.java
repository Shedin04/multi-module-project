package com.shedin.restfullbooker.stepdefs;

import com.shedin.restfullbooker.requestprovider.TokenRequest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;


import static com.shedin.apicore.utility.TestContext.unloadTestData;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScenarioHooks {
	@Autowired
	private TokenRequest tokenRequest;

	@Before(value = "@GetToken", order = 1)
	public void createToken() {
		Response response = tokenRequest.createAuthorizationToken();
		assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Token wasn't created");
	}

	@After(order = 1)
	public void clearTestData() {
		unloadTestData();
	}
}