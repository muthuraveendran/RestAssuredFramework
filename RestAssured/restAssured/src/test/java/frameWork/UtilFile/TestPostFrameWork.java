package frameWork.UtilFile;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.automation.helper.GenericHelper;
import api.automation.helper.UserManagementHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestPostFrameWork {
	
	GenericHelper helper;
	Properties propery;
	String baseUrl;
	UserManagementHelper user;
	Response response;
	
	@BeforeClass
	public void voideSetup() throws IOException {
		helper = new GenericHelper();
		propery = helper.loadPrperties("config");
		baseUrl =  propery.getProperty("baseUrl");
		user = new UserManagementHelper(baseUrl);
	}
	
	@Test
	public void postUserDetails() throws Exception {
		//Asserting status code 200
		//Asserting DOB,Name and AddressLine2
		
		//By hitting allusers api and taking api count
		Response allUser = user.getAllUser();
		List<String> name = JsonPath.from(allUser.getBody().asString()).get("name"); 
		int lenghSize = name.size();
		System.out.println("lenghSizelenghSizelenghSizelenghSizelenghSizelenghSize"+lenghSize);
		
		//Reading Test data from JSON file
		Map<String,String> testData = new HashMap<String,String>();
		testData = helper.readJson("addUser", "Data", "data.json");

		// We are adding user
		response =  user.addUser(testData);
//		response.prettyPrint();
		String dob = JsonPath.from(response.getBody().asString()).get("dob"); 
		String addressLine1 = JsonPath.from(response.getBody().asString()).get("addressDetails.addressLine1").toString();
		String addressLine2 = JsonPath.from(response.getBody().asString()).get("name"); 
		
		//By hitting allusers api and taking api count
				Response latestUser = user.getAllUser();
			List<String> latestName = JsonPath.from(latestUser.getBody().asString()).get("name"); 
				int latestSize = latestName.size();
		
		int statusCode = response.getStatusCode();	
		
		assertThat(new Object[] {latestSize,Integer.parseInt(testData.get("statusCode")),testData.get("dob"),testData.get("addressLine11"),testData.get("name")},
				is(new Object[] {lenghSize+1,statusCode,dob,addressLine1,addressLine2}));
	}

}
