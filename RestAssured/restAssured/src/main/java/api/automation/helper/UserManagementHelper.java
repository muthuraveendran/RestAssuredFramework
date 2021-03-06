package api.automation.helper;

import java.util.Map;
import api.automation.pojo.UsersPOJO;
import api.automation.utils.RestUtils;
import api.automation.utils.URLGenerator;
import io.restassured.response.Response;

public class UserManagementHelper {
	String baseURL;
	RestUtils utils;
	URLGenerator url;
	UsersPOJO usersPojo;
	
	public UserManagementHelper(String baseURL) {
		this.baseURL = baseURL;
		utils = new RestUtils();
		url = new URLGenerator(baseURL);
		usersPojo = new UsersPOJO();
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
	
	public Response addUser(Map<String,String> testData) throws Exception {
		Response response;
		String payload = usersPojo.addData(testData);
		try {
			response = utils.postRequest(url.addUsers,payload);
			if(response.getStatusCode()!=200) {
				throw new Exception("Failed to get user with id"+payload+"url.getUsers"+url.addUsers);
			}
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return response;
		
	}
	
	
	public Response getAllUser() throws Exception {
		Response response;
		try {
			response = utils.get(url.getUsers);
			if(response.getStatusCode()!=200) {
				throw new Exception("Failed to get user with id"+"url.getUsers"+url.addUsers);
			}
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return response;
		
	}
}
