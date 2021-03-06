package api.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readPropertyFile {
	
	public static void main(String[] args) throws IOException {
		String prpertyFile = "qa";
		Properties pro = loadPrperties(prpertyFile);
		System.out.print(pro.get("baseUrl"));
		
	}
	
	public static Properties loadPrperties(String fileName ) throws IOException {
		String path = System.getProperty("user.dir") + File.separator + "resources" + File.separator + fileName +".properties";
		File file = new File(path);
		
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		return prop;
		
		
	}

}
