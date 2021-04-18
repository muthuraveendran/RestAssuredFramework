package frameWork.UtilFile;

import java.util.HashMap;
import org.testng.annotations.Test;
import api.automation.utils.RestUtils;

public class TestDeleteRequest {
	
	@Test
	public void deleteApi( ) {
		String uri = "http://localhost:8081/users";
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		data.put("data", 18);
		
		RestUtils utils = new RestUtils();
		
		utils.deleteRequest(uri, data);
		
	}

}
