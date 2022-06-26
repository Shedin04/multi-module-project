package com.shedin.restfullbooker.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorizationCredentialsResponse {
	private String token;
}