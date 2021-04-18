package com.restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class restDemo {
	
	@Test
	public void getUserDetailsQueryParam() {
		
		RestAssured.baseURI = "http://localhost:8081";
		
		RestAssured.given().param("data", "1")
		.when().get("/users/").then().assertThat().statusCode(200);
		
	}

}
