package api.automation.utils;

public class URLGenerator {
	
	public String getUsers = "/users";
	public String addUsers = "/users";
	public String updateUsers = "/user";
	public String deleteUsers = "/users";
	
	public URLGenerator(String baseUrl) {
		// TODO Auto-generated constructor stub
		getUsers = baseUrl + getUsers;
		addUsers = baseUrl + addUsers;
		updateUsers = baseUrl + updateUsers;
		deleteUsers = baseUrl + deleteUsers;
	}

}
