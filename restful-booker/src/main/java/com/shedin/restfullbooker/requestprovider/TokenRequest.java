package com.shedin.restfullbooker.requestprovider;

import com.shedin.apicore.helpers.ConfigurationApiHelper;
import com.shedin.apicore.utility.JsonConverter;
import com.shedin.restfullbooker.dto.request.AuthorizationCredentialsRequest;
import com.shedin.restfullbooker.dto.response.AuthorizationCredentialsResponse;
import com.shedin.restfullbooker.helpers.EndpointsHelper;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.shedin.apicore.constants.StringConstants.RequestParameters.TOKEN;
import static com.shedin.apicore.request.BaseRequest.postRequest;
import static com.shedin.apicore.utility.TestContext.saveSharedParameter;
import static com.shedin.restfullbooker.constants.Constants.JsonFiles.USER_CREDENTIALS_FILE;


@Lazy
@Component
public class TokenRequest {
	private final ConfigurationApiHelper configurationAPIHelper;
	private final EndpointsHelper endpointsHelper;
	private final JsonConverter jsonConverter;

	@Autowired
	public TokenRequest(ConfigurationApiHelper configurationAPIHelper, EndpointsHelper endpointsHelper,
			JsonConverter jsonConverter) {
		this.configurationAPIHelper = configurationAPIHelper;
		this.endpointsHelper = endpointsHelper;
		this.jsonConverter = jsonConverter;
	}

	public Response createAuthorizationToken() {
		AuthorizationCredentialsRequest authorizationCredentialsDto = (AuthorizationCredentialsRequest) jsonConverter.convertJsonToObject(
				USER_CREDENTIALS_FILE, AuthorizationCredentialsRequest.class);
		Response response = postRequest(configurationAPIHelper.getBaseURL() + endpointsHelper.getAuthenticationUrl(),
										authorizationCredentialsDto);
		saveSharedParameter(TOKEN, response.as(AuthorizationCredentialsResponse.class).getToken());
		return response;
	}
}