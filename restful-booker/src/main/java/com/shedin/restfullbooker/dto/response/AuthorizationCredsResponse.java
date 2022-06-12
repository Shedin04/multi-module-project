package com.shedin.restfullbooker.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorizationCredsResponse {
	private String token;
}