package com.shedin.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class GetBookingResponse {
	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	private BookingDates bookingdates;
	private String additionalneeds;

	@Setter
	@Getter
	@NoArgsConstructor
	private static class BookingDates {
		private String checkin;
		private String checkout;
	}
}