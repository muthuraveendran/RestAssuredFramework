package api.automation.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.io.FileReader;


import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class readJsonFile {
	
	
	
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		String path = System.getProperty("user.dir")+File.separator+"resources"+File.separator+"Data"+File.separator+"data.json";
		
		 JsonElement jsonElement = (new JsonParser()).parse(new FileReader(path));

		 JsonObject object = jsonElement.getAsJsonObject();
		 JsonElement ele = object.get("addUser");
		 JsonObject jobject = ele.getAsJsonObject();
		 
		 Map<String,String> myObject = new HashMap<String,String>();
		 Iterator iterator = jobject.entrySet().iterator();
		 while(iterator.hasNext()) {
			 Entry entry = (Entry) iterator.next();
			 myObject.put(entry.getKey().toString(), entry.getValue().toString());
		 }
		 
	
		System.out.println(myObject.get("landmark1"));
		
	}

}
