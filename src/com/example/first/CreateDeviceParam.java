package com.example.first;

import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

public class CreateDeviceParam implements IJsonConverter {
	
	private String _userName;
	private String _password;
	private String _deviceGuid;
	private String _deviceName;
	
	public CreateDeviceParam(String userName, String password, UUID deviceGuid, String deviceName) {
		_userName = userName;
		_password = password;
		_deviceGuid = deviceGuid.toString();
		_deviceName = deviceName;
	}

	public String get_userName() {
		return _userName;
	}
	
	public String get_password(){
		return _password;
	}
	
	public String get_deviceGuid(){
		return _deviceGuid;
	}
	
	public String get_deviceName(){
		return _deviceName;
	}

	@Override
	public JSONObject toJsonObject() {
		
		 JSONObject json = new JSONObject();
         try
         {
        	 json.put("UserName", _userName);
        	 json.put("Password", _password);
             json.put("DeviceGuid", _deviceGuid);
             json.put("DeviceName", _deviceName);
         }
         catch (JSONException e)
         {
        	 e.printStackTrace();
         }
         
         return json;
	}
}