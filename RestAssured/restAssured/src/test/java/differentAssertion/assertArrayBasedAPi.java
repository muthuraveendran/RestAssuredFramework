package differentAssertion;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.ArrayList;
import java.util.List;

public class assertArrayBasedAPi {
	
	@Test
	public void assertMultipleApi() {
		
	
	List<String>  landmark, cardId;
	List<Integer> pin;
		
	landmark = new ArrayList<String>();
	cardId = new ArrayList<String>();
	pin = new ArrayList<Integer>();

	
	RestAssured.baseURI = "http://localhost:8081";
	Response response = given().get("/users");
	
//	landmark = new ArrayList<String>();
	landmark = JsonPath.from(response.getBody().asString()).get("addressDetails.landmark");
//	cardId = new ArrayList<String>();
	cardId = JsonPath.from(response.getBody().asString()).get("addressDetails.officeAddress.cardId");
//	pin = new ArrayList<Integer>();
	pin = JsonPath.from(response.getBody().asString()).get("addressDetails.officeAddress.pin");
	
	assertThat((new Object[]{landmark.get(0),cardId.get(0),pin.get(0),
			landmark.get(1),cardId.get(1),pin.get(1),
			landmark.get(2),cardId.get(2),pin.get(2)}), is(new Object[]{"Near Airport Road","EMP-001",75943764,
					"Old Airport Road","EMP-002",75943765,"Old Bus Road","EMP-003",75943766}));

	

	}

}
