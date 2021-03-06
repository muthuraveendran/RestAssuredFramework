package differentAssertion;

//import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;


public class assertionFrameWork {
	
	@Test
	
	public void assertFrameWork() {
		
		String name, addressLine1, landmark, cardId;
		int aaddharNumer, pin;
		
		RestAssured.baseURI ="http://localhost:8081";
		
			Response response = given().get("/users/1");
			
			aaddharNumer = JsonPath.from(response.getBody().asString()).get("addressDetails.aadharNumber"); 
			addressLine1 = JsonPath.from(response.getBody().asString()).get("addressDetails.addressLine1"); 
			landmark = JsonPath.from(response.getBody().asString()).get("addressDetails.landmark"); 
			
			cardId = JsonPath.from(response.getBody().asString()).get("addressDetails.officeAddress.cardId"); 
			pin = JsonPath.from(response.getBody().asString()).get("addressDetails.officeAddress.pin"); 
			name = JsonPath.from(response.getBody().asString()).get("name"); 
			
		//Assertion
			assertThat((new Object[]{name, addressLine1, landmark, aaddharNumer, cardId, pin}),//
					is(new Object[] {"litteleHelpByKR-1","Mg Road-1","Near Airport Road",32345,"EMP-001",75943764}));//


			
		
		
	}

}
