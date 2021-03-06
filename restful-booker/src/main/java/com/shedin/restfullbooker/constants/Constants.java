package com.shedin.restfullbooker.constants;

import lombok.experimental.UtilityClass;


@UtilityClass
public final class Constants {

	// values
	public enum Values {;
		public static final String ALL_BOOKINGS_RESPONSE = "all_bookings_response";
		public static final String BOOKING_RESPONSE = "booking_response";
		public static final String NEW_BOOKING = "new_booking";
	}

	// json-files
	public enum JsonFiles {;
		public static final String USER_CREDENTIALS_FILE = "json/user-creds.json";
		public static final String CREATE_BOOKING_FILE = "json/create-booking.json";
	}

	// regular constants
	public enum RegularData {;
		public static final String FIRST_NAME = "firstName";
		public static final String LAST_NAME = "lastName";
	}
}