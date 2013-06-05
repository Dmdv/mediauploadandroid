package com.example.first;

import java.io.IOException;
import java.util.UUID;
import org.apache.http.client.ClientProtocolException;

public class SampleRequest {
	
	public static User CreateUser() {
		
		User user = createUser();
		
		try {
			
			RestEasy.doPost(RestCommand.get_Host() + RestCommand.CreateUser(), EntityFactory.createStringEntity(user.toJsonObject()));
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	public static void CreateDevice() {
		
		User user = CreateUser();
		
		UUID deviceGuid = UUID.randomUUID();
		String deviceName =  UUID.randomUUID().toString();
	
		CreateDeviceParam param = new CreateDeviceParam(user.get_Name(), user.get_Password(), deviceGuid, deviceName);
		
		try {
			
			RestEasy.doPost(RestCommand.get_Host() + RestCommand.CreateDevice(), EntityFactory.createStringEntity(param.toJsonObject()));
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void GetImage() {
	}

	public static void UploadImage() {
		
		User user = CreateUser();
		
		UUID deviceGuid = UUID.randomUUID();
		String deviceName =  UUID.randomUUID().toString();
	
		CreateDeviceParam param = new CreateDeviceParam(user.get_Name(), user.get_Password(), deviceGuid, deviceName);
		
		try {
			
			RestEasy.doPost(RestCommand.get_Host() + RestCommand.CreateDevice(), EntityFactory.createStringEntity(param.toJsonObject()));
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// TODO:
		String filePath = "";
		
		try {
			
			String url = RestCommand.get_Host() + RestCommand.UploadPreview(filePath, deviceGuid.toString());
			RestEasy.doPost(url, EntityFactory.createFileEntity(filePath));
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static User createUser() {
		String name =  UUID.randomUUID().toString();
		String password =  UUID.randomUUID().toString();
		return new User(UUID.randomUUID(), name, password);	
	}
}
