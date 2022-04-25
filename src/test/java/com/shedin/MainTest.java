package com.shedin;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class MainTest {
	public static final String URL = "https://gorest.co.in/";
	public static final String API_PATH = "public/v2/users";

	public static void main(String[] args) {
		assertNotNull(URL);
		System.out.println("--GUI--");
		UIUtils.openPage(URL);
		System.out.println("--API--");
		String response = APIUtils.sendGetRequest(URL + API_PATH);
		assertNotNull(response);
		System.out.println(response);
	}
}
