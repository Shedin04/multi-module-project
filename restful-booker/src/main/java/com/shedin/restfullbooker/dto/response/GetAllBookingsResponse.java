package com.shedin.restfullbooker.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;


@Setter
@Getter
@NoArgsConstructor
public class GetAllBookingsResponse {
	private BigInteger bookingid;
}