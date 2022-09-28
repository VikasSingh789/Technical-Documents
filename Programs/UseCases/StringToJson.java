package com.sample.practice;
import org.json.JSONObject;

public class StringToJson {

	public static void main(String[] args) {
		
		String string = "{\"name\": \"Sam Smith\", \"technology\": \"Python\", \"company\": \"CTS\"}";  
		JSONObject json = new JSONObject(string);  
		System.out.println(json.toString());  
		String technology = json.getString("company");  
		System.out.println(technology);
		
		
  

	}

}
