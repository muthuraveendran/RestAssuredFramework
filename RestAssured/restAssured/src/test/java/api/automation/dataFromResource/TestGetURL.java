package api.automation.dataFromResource;

import java.util.Map;

import api.automation.utils.RestUtils;
import api.automation.utils.URLGenerator;
import io.restassured.response.Response;

public class TestGetURL {
	String baseURL;
	RestUtils utils;
	URLGenerator url;
	
	public TestGetURL(String baseURL) {
		this.baseURL = baseURL;
		utils = new RestUtils();
		url = new URLGenerator(baseURL);
	}
	
	public Response getSpecificUserDetails(Map<String,String> testData) throws Exception {
		Response response;
		int id =Integer.parseInt(testData.get("id"));
		try {
			response = utils.get(url.getUsers+"/"+id);
			if(response.getStatusCode()!=200) {
				throw new Exception("Failed to get user with id"+id+"url.getUsers"+url.getUsers);
			}
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return response;
		
	}

}
