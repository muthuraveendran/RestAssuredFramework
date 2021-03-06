package api.automation.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class GenericHelper {
	
public Map<String, String> readJson(String jsonObj, String folder, String filename) throws JsonIOException, JsonSyntaxException, FileNotFoundException {
	
	//String path = System.getProperty("user.dir")+File.separator+"resources"+File.separator+"Data"+File.separator+"data.json";
	String path = System.getProperty("user.dir")+File.separator+"resources"+File.separator+folder+File.separator+filename;
	 JsonElement jsonElement = (new JsonParser()).parse(new FileReader(path));
	 JsonObject object = jsonElement.getAsJsonObject();
//	 JsonElement ele = object.get("addUser");
	 JsonElement ele = object.get(jsonObj);
	 JsonObject jobject = ele.getAsJsonObject();
	 
	 Map<String,String> myObject = new HashMap<String,String>();
	 Iterator iterator = jobject.entrySet().iterator();
	 while(iterator.hasNext()) {
		 Entry entry = (Entry) iterator.next();
		 myObject.put(entry.getKey().toString(), entry.getValue().toString().replace("\"", ""));
	 }
	return myObject;
	
}

public Properties loadPrperties(String fileName ) throws IOException {
	String path = System.getProperty("user.dir") + File.separator + "resources" + File.separator + fileName +".properties";
	File file = new File(path);
	
	FileInputStream fileInput = new FileInputStream(file);
	Properties prop = new Properties();
	prop.load(fileInput);
	return prop;
	
	
}

}
