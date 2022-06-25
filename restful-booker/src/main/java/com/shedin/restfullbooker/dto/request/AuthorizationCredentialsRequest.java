package com.shedin.restfullbooker.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorizationCredentialsRequest {
	private String username;
	private String password;
}