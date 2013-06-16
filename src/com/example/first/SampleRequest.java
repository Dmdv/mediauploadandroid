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

	public static CreateDeviceParam CreateDevice() {
		
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
		
		return param;
	}

	public static void GetImage() {
	}

	public static void UploadImage() {
		
		CreateDeviceParam param = CreateDevice();
		
		// TODO:
		String filePath = "/mnt/sdcard/Image.jpg";
		String filename = "Image222.jpg";
		
		try {
			
			String url = RestCommand.get_Host() + RestCommand.UploadPreview(filename, param.get_deviceGuid());
			RestEasy.doPostRaw(url, EntityFactory.createFileEntity(filePath));
			
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
