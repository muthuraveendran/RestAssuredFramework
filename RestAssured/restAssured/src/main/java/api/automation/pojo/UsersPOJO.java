package api.automation.pojo;

import java.util.Map;

import com.google.gson.Gson;

public class UsersPOJO {
	
	private int id;
	private String name;
	private String dob;
	private HomeAddressPOJO addressDetails;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public HomeAddressPOJO getAddressDetails() {
		return addressDetails;
	}
	public void setAddressDetails(HomeAddressPOJO addressDetails) {
		this.addressDetails = addressDetails;
	}
	
	public String userData(Map<String,String> testData) {
		
		OfficeAddressPOJO officeaddress = new OfficeAddressPOJO();
		officeaddress.setBuildingNumber(Integer.parseInt(testData.get("buildingNumber")));
		officeaddress.setAddressLine1(testData.get("addressLine1"));
		officeaddress.setAddressLine2(testData.get("addressLine2"));
		officeaddress.setLandmark(testData.get("landMark"));
		officeaddress.setCardId(testData.get("cardId"));
		officeaddress.setPin(Integer.parseInt(testData.get("pin")));
		
		HomeAddressPOJO homeaddress = new HomeAddressPOJO();
		homeaddress.setHouseNumber(testData.get("houseNumber"));
		homeaddress.setAadharNumber(Integer.parseInt(testData.get("aadharNumber")));
		homeaddress.setAddressLine1(testData.get("addressLine1"));
		homeaddress.setAddressLine2(testData.get("addressLine2"));
		homeaddress.setLandmark(testData.get("landmark"));
		homeaddress.setPin(Integer.parseInt(testData.get("pin")));
		homeaddress.setOfficeAddress(officeaddress);
		
		UsersPOJO user = new UsersPOJO();
		user.setId(Integer.parseInt(testData.get("id")));
		user.setName(testData.get("name"));
		user.setDob(testData.get("dob"));
		user.setAddressDetails(homeaddress);
		
		Gson gson = new Gson();
		return gson.toJson(user);	
	}
	
	
	public String addData(Map<String,String> testData) {
		
		OfficeAddressPOJO officeaddress = new OfficeAddressPOJO();
		officeaddress.setBuildingNumber(Integer.parseInt(testData.get("buildingNumber01")));
		officeaddress.setAddressLine1(testData.get("addressLine01"));
		officeaddress.setAddressLine2(testData.get("addressLine02"));
		officeaddress.setLandmark(testData.get("landmark01"));
		officeaddress.setCardId(testData.get("cardId01"));
		officeaddress.setPin(Integer.parseInt(testData.get("pin01")));
		
		HomeAddressPOJO homeaddress = new HomeAddressPOJO();
		homeaddress.setHouseNumber(testData.get("houseNumber"));
		homeaddress.setAadharNumber(Integer.parseInt(testData.get("aadharNumber")));
		homeaddress.setAddressLine1(testData.get("addressLine11"));
		homeaddress.setAddressLine2(testData.get("addressLine22"));
		homeaddress.setLandmark(testData.get("landmark11"));
		homeaddress.setPin(Integer.parseInt(testData.get("pin11")));
		homeaddress.setOfficeAddress(officeaddress);
		
		UsersPOJO user = new UsersPOJO();
		user.setId(Integer.parseInt(testData.get("id")));
		user.setName(testData.get("name"));
		user.setDob(testData.get("dob"));
		user.setAddressDetails(homeaddress);
		
		Gson gson = new Gson();
		return gson.toJson(user);	
	}
	
	public String updateUser(Map<String, String> data) {
		UsersPOJO user = new UsersPOJO();
		user.setName(data.get("name"));
		user.setDob(data.get("dob"));
		
		Gson gson = new Gson();
		return gson.toJson(user);
		
	}

	

}
