package api.resource;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class Resource {
	
	public String data () {
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
		
		Gson gson = new Gson();
		return gson.toJson(data);
	}
	

}
