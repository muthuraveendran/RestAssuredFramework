package differentAssertion;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class testAssertion {
	
	@Test
	 
	public void testAssert() {
		
		RestAssured.baseURI = "http://localhost:8081";
		
		given().get("users/1").
		then().assertThat().
		body("name",equalTo("litteleHelpByKR-1")).
		and().body("addressDetails.aadharNumber",equalTo(32345)).
		and().body("addressDetails.officeAddress.pin",is(75943764)).
		and().body("addressDetails.officeAddress",hasKey("pin")).
		and().body("addressDetails.officeAddress",hasEntry("pin",75943764))
		;
	}
	
	@Test
	 
	public void testArrayItem() {
		
		RestAssured.baseURI = "http://localhost:8081";
		
		given().get("users").
		then().assertThat().
		body("name",hasItem("litteleHelpByKR-1")).
		and().body("addressDetails.aadharNumber",hasItems(32345,32345));
	}

}
