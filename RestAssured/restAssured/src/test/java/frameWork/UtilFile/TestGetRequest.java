package frameWork.UtilFile;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import api.automation.utils.RestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestGetRequest {
	
	@Test
	public void getusers() {
		String url = "http://localhost:8081";
		RestUtils restUtils = new RestUtils();
//		Response response = restUtils.get(url);
		
		//Map .
		String key ="data";
		int value=1;				
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put(key, value);
		map.put("pin", 123);
		
		Response response = restUtils.getParam(url,map);
		response.prettyPrint();
	}

}
