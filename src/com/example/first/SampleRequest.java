package com.example.first;

import java.io.IOException;
import java.util.UUID;
import org.apache.http.client.ClientProtocolException;

public class SampleRequest {
	
	public static User CreateUser() {
		
		User user = createUser();
		
		try {
			
			RestEasy.doPost(RestCommand.get_Host() + RestCommand.CreateUser(), EntityFactory.CreateStringEntity(user.toJsonObject()));
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	private static User createUser() {
		String name =  UUID.randomUUID().toString();
		String password =  UUID.randomUUID().toString();
		return new User(UUID.randomUUID(), name, password);	
	}

	public static void GetImage() {
	}

	public static void UploadImage() {
	}

	public static void CreateDevice() {
		
		User user = CreateUser();
		
		UUID deviceGuid = UUID.randomUUID();
		String deviceName =  UUID.randomUUID().toString();

		CreateDeviceParam param = new CreateDeviceParam(user.get_Name(), user.get_Password(), deviceGuid, deviceName);
		
		try {
			
			RestEasy.doPost(RestCommand.get_Host() + RestCommand.CreateDevice(), EntityFactory.CreateStringEntity(param.toJsonObject()));
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
