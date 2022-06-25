package com.shedin.restfullbooker.stepdefs;

import com.shedin.apicore.utility.JsonConverter;
import com.shedin.restfullbooker.dto.request.CreateBookingRequest;
import com.shedin.restfullbooker.requestprovider.BookingRequest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import static com.shedin.restfullbooker.constants.Constants.JsonFiles.CREATE_BOOKING_FILE;
import static com.shedin.restfullbooker.constants.Constants.RegularData.FIRST_NAME;
import static com.shedin.restfullbooker.constants.Constants.RegularData.LAST_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreateBookingStepdefs {
	@Autowired
	private BookingRequest bookingRequest;

	@Autowired
	private JsonConverter jsonConverter;

	@Given("^the customer successfully creates default booking for person:$")
	public void the_customer_successfully_creates_default_booking_for_the_person(DataTable dataTable) {
		CreateBookingRequest createBookingRequest = (CreateBookingRequest) jsonConverter
				.convertJsonToObject(CREATE_BOOKING_FILE, CreateBookingRequest.class);
		createBookingRequest.setFirstname(dataTable.asMap().get(FIRST_NAME));
		createBookingRequest.setLastname(dataTable.asMap().get(LAST_NAME));
		Response response = bookingRequest.createNewBooking(createBookingRequest);
		assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Incorrect status code");
	}
}