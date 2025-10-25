package com.PetStore.BaseAPIClass;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import genericUtilities.DataBaseUtil;
import genericUtilities.FileUtil;
import genericUtilities.JavaUtil;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseAPIClass {
	public JavaUtil jlib = new JavaUtil();
	public FileUtil flib = new FileUtil();
	public DataBaseUtil DBlib = new DataBaseUtil();
	public static RequestSpecification reqSpecObject;
	public static ResponseSpecification resSpecObject;
	@BeforeSuite
	public void configBS() throws ClassNotFoundException, SQLException, IOException {
		DBlib.connectToDB();
		
		
		RequestSpecBuilder reqObj = new RequestSpecBuilder();
		reqObj.setContentType(ContentType.JSON);
		reqObj.setBaseUri(flib.getValueFromPropertiesFile("BASEUri"));
		reqSpecObject = reqObj.build();
		
		ResponseSpecBuilder resObj = new ResponseSpecBuilder();
		resObj.expectContentType(ContentType.JSON);
		resSpecObject = resObj.build();
	}
	@AfterSuite
	public void configAS() throws SQLException {
		DBlib.closeConnection();
	}
}
