package com.shedin.restfullbooker.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;


@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetAllBookingsResponse {
	private BigInteger bookingid;
}