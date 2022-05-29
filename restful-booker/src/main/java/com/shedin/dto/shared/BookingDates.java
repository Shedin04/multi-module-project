package com.shedin.dto.shared;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class BookingDates {
	private String checkin;
	private String checkout;
}