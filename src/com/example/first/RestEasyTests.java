package com.example.first;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.mime.content.StringBody;
import org.json.JSONObject;

public class RestEasyTests {
	
	public static void TestPost(){
		try {
			
			// TODO: Use mock for RestEasy class.
			
			JSONObject jsonObject = new JSONObject();
			
			HttpEntity entity = EntityFactory.createStringEntity(jsonObject);
			
	        RestEasy.doPost(RestCommand.get_Host() + RestCommand.CreateUser(), entity);
	        
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void TestMultiPartEntity(){
        try {
        	
        	HttpEntity entity = EntityFactory.createGenericMultipartEntity("file", new StringBody("sample body"));
        	
			RestEasy.doPost(RestCommand.get_Host() + RestCommand.CreateUser(), entity);
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
