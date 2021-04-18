package api.automation.utils;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.Map;



public class RestUtils {
	
	public Response get(String url){
		return given().
		header("Authorization","Bearer").
		header("Content-Type","application/json").
		get(url);
		
	}
	
	public Response getParam(String url , Map<String,Integer> mapdata){
		return given().
				queryParams(mapdata).log().all().
		get(url);
		
	}
	
	public Response postRequest(String url, String body) {
		return given().
				contentType("application/json").
				log().all().
				body(body).
				post(url);
				
	}
	
	public Response putRequest(String url, String body) {
		return given().
				contentType("application/json").
				log().all().
				body(body).
				put(url);
				
	}
	
	public Response deleteRequest(String url , Map<String,Integer> data ) {
		
		return given().
				queryParams(data).
				log().all().
				delete(url);
	}
	
	
	
	

}
