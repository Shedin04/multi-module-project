package com.shedin.restfullbooker.requestprovider;

import com.google.gson.Gson;
import com.shedin.apicore.helpers.ConfigurationAPIHelper;
import com.shedin.apicore.utility.JsonConverter;
import com.shedin.restfullbooker.dto.request.AuthorizationCredsRequest;
import com.shedin.restfullbooker.helpers.EndpointsHelper;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.shedin.apicore.request.BaseRequest.postRequest;
import static com.shedin.restfullbooker.constants.Constants.JsonFiles.USER_CREDS_FILE;


@Lazy
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenRequest {
	@Autowired
	private ConfigurationAPIHelper configurationAPIHelper;
	@Autowired
	private EndpointsHelper endpointsHelper;
	@Autowired
	private JsonConverter jsonConverter;

	public Response getAuthorizationToken() {
		AuthorizationCredsRequest authorizationCredsDto = (AuthorizationCredsRequest) jsonConverter.convertJsonToObject(
				USER_CREDS_FILE, AuthorizationCredsRequest.class);
		return postRequest(configurationAPIHelper.getBaseURL() + endpointsHelper.getAuthenticationUrl(), HttpStatus.SC_OK,
						   authorizationCredsDto);
	}
}