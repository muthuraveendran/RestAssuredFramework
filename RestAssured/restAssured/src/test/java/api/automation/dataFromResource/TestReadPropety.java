package api.automation.dataFromResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import api.automation.helper.GenericHelper;

public class TestReadPropety {
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, IOException {
		
		//Read Json file
		GenericHelper generic = new GenericHelper();
		Map<String,String> map  = new HashMap<String,String> ();
		
//		Properties readFile = generic.loadPrperties("newFile");
//		String p =readFile.get("selectObject").toString();
//		map = generic.readJson(p,"Data","qaData.json");

		map = generic.readJson("readJson","Data","qaData.json");
		System.out.println(	map.get("name"));
		
		//Read Property file
		Properties prop = generic.loadPrperties("qa");
		System.out.println(prop.get("baseUrl"));
		
		
		
	}

}
