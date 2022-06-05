package com.shedin.restfullbooker.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class AuthorizationCredsResponse {
	private String token;
}