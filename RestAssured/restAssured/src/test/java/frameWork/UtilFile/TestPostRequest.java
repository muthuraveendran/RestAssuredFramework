package frameWork.UtilFile;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.automation.pojo.UsersPOJO;
import api.automation.utils.RestUtils;
import api.resource.Resource;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestPostRequest {
	
	
	@Test
	public void createRequestedData() {
		String url = "http://localhost:8081/users";

				RestUtils restutils = new RestUtils();
				UsersPOJO user = new UsersPOJO();
				
				Map <String , String> data = new HashMap<String, String>();
				data.put("buildingNumber", "12345");
				data.put("addressLine1", "tokyo");
				data.put("addressLine2", "tokyo1");
				data.put("landMark", "cross street");	
				data.put("cardId", "Card012345");
				data.put("pin", "0123456");
				
				data.put("houseNumber", "Q14");
				data.put("aadharNumber", "211212");
				data.put("addressLine1", "Old Mg Nagar");
				data.put("addressLine2", "old cross street");
				data.put("landmark", "old cross road");
				
				data.put("id", "15963");
				data.put("name", "Ajay");
				data.put("dob", "2000-05-05");
	
				String jsonData =  user.userData(data);				
				
				Response response = restutils.postRequest(url, jsonData);
				
	
				Assert.assertEquals(response.getStatusCode(), 200);
				response.prettyPrint();
				
				// how to asset particular json value
//				
		         String responseBody= response.asString();
		         JsonPath path=new JsonPath(responseBody);
		         String key=path.get("name");
		         System.out.println("keykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykey"+key);

				
		
		
	}
	

}
