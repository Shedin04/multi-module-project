package com.shedin.restfullbooker.dto.shared;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookingDates {
	private String checkin;
	private String checkout;
}