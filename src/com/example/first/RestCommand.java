package com.example.first;

public class RestCommand
{
	private static String UserManager = "/Service.svc/UserManager";
	private static String DeviceManager = "/Service.svc/MediaRepositoryService";
	
	public static String get_Host(){
		return "http://mediaupload2.cloudapp.net";
	}

	public static String CreateUser(){
		return UserManager + "/create/user";
	}

	public static String IsUserExists(){
		return UserManager + "/isuserexists";
	}

	public static String CreateDevice(){
		return DeviceManager + "/create/device";
	}

	public static String UploadOriginal(String fileName, String deviceId){
		return DeviceManager + "/uploadoriginal/" + fileName + "/" + deviceId;
	}

	public static String UploadPreview(String fileName, String deviceId){
		return DeviceManager + "/uploadpreview/" + fileName + "/" + deviceId;
	}
}