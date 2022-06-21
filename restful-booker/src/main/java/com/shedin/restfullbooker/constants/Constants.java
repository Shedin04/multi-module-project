package com.shedin.restfullbooker.constants;

public interface Constants {
	//value
	interface Values {
		String ALL_BOOKINGS_RESPONSE = "all_bookings_response";
		String BOOKING_RESPONSE = "booking_response";
		String NEW_BOOKING = "new_booking";
	}

	// json-files
	interface JsonFiles {
		String USER_CREDS_FILE = "json/user-creds.json";
		String CREATE_BOOKING_FILE = "json/create-booking.json";
	}

	// regular constants
	interface RegularData {
		String FIRST_NAME = "firstName";
		String LAST_NAME = "lastName";
	}
}