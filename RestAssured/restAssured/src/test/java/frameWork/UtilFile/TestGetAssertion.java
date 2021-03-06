package frameWork.UtilFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



import api.automation.helper.GenericHelper;
import api.automation.helper.UserManagementHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestGetAssertion {
	GenericHelper helper;
	Properties propery;
	String baseUrl;
	UserManagementHelper user;
	
	@BeforeClass
	public void voideSetup() throws IOException {
		helper = new GenericHelper();
		propery = helper.loadPrperties("config");
		baseUrl =  propery.getProperty("baseUrl");
		user = new UserManagementHelper(baseUrl);
	}
	
	@Test
	public void getUserDetails() throws Exception {
		//Asserting status code 200
		//Asserting DOB,Name and AddressLine2
		Map<String,String> testData = new HashMap<String,String>();
		testData = helper.readJson("updateID", "Data", "data.json");
		
		Response response =  user.getSpecificUserDetails(testData);
		String dob = JsonPath.from(response.getBody().asString()).get("dob"); 
		String name = JsonPath.from(response.getBody().asString()).get("name");
		String addressLine2 = JsonPath.from(response.getBody().asString()).get("addressDetails.addressLine2"); 
		
		int statusCode = response.getStatusCode();	
		assertThat(new Object[] {statusCode,name,dob,addressLine2},
			is(new Object[] {Integer.parseInt(testData.get("statusCode")),testData.get("name"),testData.get("dob"),testData.get("addressLine2") }));
		
		response.prettyPrint();
	}

}
