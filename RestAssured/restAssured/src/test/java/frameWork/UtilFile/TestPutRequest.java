package frameWork.UtilFile;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import api.automation.pojo.UsersPOJO;
import api.automation.utils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestPutRequest {
	
	@Test
	public void updateRequest() {
		
		
		String url = "http://localhost:8081/user/6";
		UsersPOJO user = new UsersPOJO(); 
		RestUtils utils = new RestUtils();
		
		
		Map<String,String> data = new HashMap<String,String>();
		data.put("name", "Raja1");
		data.put("dob", "11-11-11");
		
		String JsoPojo =  user.updateUser(data);
		Response response =  utils.putRequest(url, JsoPojo);
		response.prettyPrint();
		
	}

}
