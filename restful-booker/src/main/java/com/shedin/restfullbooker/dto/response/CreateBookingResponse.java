package com.shedin.restfullbooker.dto.response;

import com.shedin.restfullbooker.dto.shared.BookingDates;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;


@Setter
@Getter
@NoArgsConstructor
public class CreateBookingResponse {
	private BigInteger bookingid;
	private Booking booking;

	@Setter
	@Getter
	@NoArgsConstructor
	private static class Booking {
		private String firstname;
		private String lastname;
		private BigDecimal totalprice;
		private boolean depositpaid;
		private BookingDates bookingdates;
		private String additionalneeds;
	}
}