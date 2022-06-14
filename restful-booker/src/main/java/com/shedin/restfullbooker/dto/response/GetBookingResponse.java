package com.shedin.restfullbooker.dto.response;

import com.shedin.restfullbooker.dto.shared.BookingDates;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetBookingResponse {
	private String firstname;
	private String lastname;
	private BigDecimal totalprice;
	private boolean depositpaid;
	private BookingDates bookingdates;
	private String additionalneeds;
}