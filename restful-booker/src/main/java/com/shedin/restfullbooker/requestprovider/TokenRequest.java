package com.shedin.restfullbooker.requestprovider;

import com.google.gson.Gson;
import com.shedin.restfullbooker.dto.request.AuthorizationCredsRequest;
import com.shedin.restfullbooker.constants.Constants;
import com.shedin.restfullbooker.constants.Endpoints;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.shedin.apicore.request.BaseRequest.postRequest;
import static com.shedin.apicore.utility.ConfigurationAPIHelper.getBaseURL;
import static com.shedin.apicore.utility.JsonConverter.getReader;


@Lazy
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenRequest {

	public static Response getAuthorizationToken() {
		AuthorizationCredsRequest authorizationCredsDto = new Gson().fromJson(
				getReader(Constants.USER_CREDS_FILE), AuthorizationCredsRequest.class);
		return postRequest(getBaseURL() + Endpoints.AUTHENTICATION, HttpStatus.SC_OK, authorizationCredsDto);
	}
}