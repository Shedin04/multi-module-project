package com.shedin.requestprovider;

import com.google.gson.Gson;
import com.shedin.dto.request.AuthorizationCredsRequest;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;
import org.apache.http.HttpStatus;

import static com.shedin.constants.Endpoints.AUTHENTICATION;
import static com.shedin.constants.Constants.USER_CREDS_FILE;
import static com.shedin.request.BaseRequest.postRequest;
import static com.shedin.utility.ConfigurationAPIHelper.getBaseURL;
import static com.shedin.utility.JsonConverter.getReader;


@UtilityClass
public class TokenRequest {

	public static Response getAuthorizationToken() {
		AuthorizationCredsRequest authorizationCredsDto = new Gson().fromJson(
				getReader(USER_CREDS_FILE), AuthorizationCredsRequest.class);
		return postRequest(getBaseURL() + AUTHENTICATION, HttpStatus.SC_OK, authorizationCredsDto);
	}
}