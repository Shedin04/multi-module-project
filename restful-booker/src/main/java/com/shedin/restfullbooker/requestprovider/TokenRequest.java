package com.shedin.restfullbooker.requestprovider;

import com.google.gson.Gson;
import com.shedin.apicore.utility.ConfigurationAPIHelper;
import com.shedin.apicore.utility.JsonConverter;
import com.shedin.restfullbooker.dto.request.AuthorizationCredsRequest;
import com.shedin.restfullbooker.constants.Constants;
import com.shedin.restfullbooker.constants.Endpoints;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.shedin.apicore.request.BaseRequest.postRequest;


@Lazy
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenRequest {
	@Autowired
	private ConfigurationAPIHelper configurationAPIHelper;

	@Autowired
	private JsonConverter jsonConverter;

	public Response getAuthorizationToken() {
		AuthorizationCredsRequest authorizationCredsDto = new Gson().fromJson(
				jsonConverter.getReader(Constants.USER_CREDS_FILE), AuthorizationCredsRequest.class);
		return postRequest(configurationAPIHelper.getBaseURL() + Endpoints.AUTHENTICATION, HttpStatus.SC_OK,
						   authorizationCredsDto);
	}
}