package com.shedin.restfullbooker.constants;

import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;


@UtilityClass
@Component
public class Endpoints {
	public static final String AUTHENTICATION = "/auth";
	public static final String BOOKING = "/booking/";
}