package com.petStore.user;

import org.testng.annotations.Test;

import com.PetStore.BaseAPIClass.BaseAPIClass;

import POJO.util.CreateUserPojo;
import iEndPoints.UserEndPoints;

import static io.restassured.RestAssured.*;

public class CreateUserTest extends BaseAPIClass {
	@Test
	public void createUser() {
		given()
			.spec(reqSpecObject)
			.body(new CreateUserPojo(2,"Venkat123","venkat","user","sample@gmail.com","sample@123","1234554321",0))
		.when()
			.post(UserEndPoints.CREATE_USER)
		.then()
			.spec(resSpecObject)
			.log().all();
			
	}
}
