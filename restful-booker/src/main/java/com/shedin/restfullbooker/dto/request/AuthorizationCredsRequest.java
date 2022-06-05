package com.shedin.restfullbooker.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class AuthorizationCredsRequest {
	private String username;
	private String password;
}