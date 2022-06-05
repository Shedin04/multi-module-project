package com.shedin.restfullbooker.stepdefs;

import com.google.gson.Gson;
import com.shedin.restfullbooker.dto.request.CreateBookingRequest;
import com.shedin.restfullbooker.dto.response.CreateBookingResponse;
import com.shedin.apicore.utility.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import static com.shedin.restfullbooker.constants.Constants.CREATE_BOOKING_FILE;
import static com.shedin.restfullbooker.constants.Constants.FIRST_NAME;
import static com.shedin.restfullbooker.constants.Constants.LAST_NAME;
import static com.shedin.restfullbooker.constants.Constants.NEW_BOOKING;
import static com.shedin.restfullbooker.requestprovider.BookingRequest.createNewBooking;
import static com.shedin.apicore.utility.JsonConverter.getReader;


public class CreateBookingStepdefs {

	@Given("^the customer successfully creates default booking for person:$")
	public void the_customer_successfully_creates_default_booking_for_the_person(DataTable dataTable) {
		CreateBookingRequest createBookingRequest = new Gson().fromJson(
				getReader(CREATE_BOOKING_FILE), CreateBookingRequest.class);
		createBookingRequest.setFirstname(dataTable.asMap().get(FIRST_NAME));
		createBookingRequest.setLastname(dataTable.asMap().get(LAST_NAME));
		Response response = createNewBooking(createBookingRequest);
		TestContext.saveSharedParameter(NEW_BOOKING, response.as(CreateBookingResponse.class));
	}
}