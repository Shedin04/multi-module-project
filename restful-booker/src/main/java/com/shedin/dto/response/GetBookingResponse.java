package com.shedin.dto.response;

import com.shedin.dto.shared.BookingDates;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Setter
@Getter
@NoArgsConstructor
public class GetBookingResponse {
	private String firstname;
	private String lastname;
	private BigDecimal totalprice;
	private boolean depositpaid;
	private BookingDates bookingdates;
	private String additionalneeds;
}