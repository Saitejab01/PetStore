package com.petStore.user;

import org.testng.annotations.Test;

import POJO.util.CreateUserPojo;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class CreateUserTest {
	@Test
	public void createUser() {
		RestAssured.baseURI = "";
		given()
			.body(new CreateUserPojo());
			
	}
}
