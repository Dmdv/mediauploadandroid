package com.example.first;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

public class RestEasyTests {
	
	public static void TestPost() throws ClientProtocolException, IOException{
		
		try {
			
			// Example: String entity
			
			JSONObject jsonObject = new JSONObject();
			
			StringEntity entity = new StringEntity(jsonObject.toString());
			entity.setContentEncoding("UTF-8");
	        entity.setContentType("application/json");
	        
	        RestEasy.doPost(RestCommand.get_Host() + RestCommand.CreateUser(), entity);
	        
	        // Example: Multipart entity
	        
	        MultipartEntity mpart = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
	        
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
