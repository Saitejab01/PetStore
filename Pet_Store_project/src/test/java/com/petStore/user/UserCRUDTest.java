package com.petStore.user;

import org.testng.annotations.Test;
import com.PetStore.BaseAPIClass.BaseAPIClass;
import POJO.util.CreateUserPojo;
import iEndPoints.UserEndPoints;

import static io.restassured.RestAssured.*;

public class UserCRUDTest extends BaseAPIClass {
	
	String userName = "Venkat"+jlib.getRandomNumber();
	
	@Test(priority = 1)
	public void createUser() throws InterruptedException {
		
		System.out.println("Creating User");
		given()
			.spec(reqSpecObject)
			.body(new CreateUserPojo(2,userName,"venkat","user","sample@gmail.com","sample@123","1234554321",0))
		.when()
			.post(UserEndPoints.CREATE_USER)
		.then()
			.statusCode(200)
			.log().all()
			.spec(resSpecObject);
		Thread.sleep(3000);
		waitForUserCreation(10);
	}
	
	@Test(dependsOnMethods = "createUser",priority = 3)
	public void getUser() throws InterruptedException {
		
		System.out.println("Getting User");
		given()
			.spec(reqSpecObject)
			.pathParam("username", userName)
		.when()
			.get(UserEndPoints.GET_USER)
		.then()
			.statusCode(200)
			.log().all()
			.spec(resSpecObject);	
	}
	
	@Test(dependsOnMethods = "createUser",priority=4)
	public void login() {
		System.out.println("User Loging in");
		given()
		.spec(reqSpecObject)
		.queryParam("username", userName)
		.queryParam("password", "sample@123")
	.when()
		.get(UserEndPoints.LOGIN_USER)
	.then()
		.statusCode(200)
		.log().all()
		.spec(resSpecObject);
	}
	
	@Test(dependsOnMethods = "login",priority=5)
	public void logout() {
		System.out.println("User Logging out");
		given()
		.spec(reqSpecObject)
	.when()
		.get(UserEndPoints.LOGOUT_USER)
	.then()
		.statusCode(200)
		.log().all()
		.spec(resSpecObject);
	}
	
	@Test(priority = 2)
	public void updateUser() throws InterruptedException {
		System.out.println("Updating User");
		given()
			.spec(reqSpecObject)
			.pathParam("username", userName)
			.body(new CreateUserPojo(2,userName,"venkat","user","sample@gmail.com","Practice@123","1234554321",0))
		.when()
			.put(UserEndPoints.UPDATE_USER)
		.then()
			.statusCode(200)
			.log().all()
			.spec(resSpecObject);
		Thread.sleep(3000);
	}
	
	@Test(priority = 6)
	public void deleteUser() {
		System.out.println("Deleting User");
		given()
			.spec(reqSpecObject)
			.pathParam("username", userName)
		.when()
			.delete(UserEndPoints.DELETE_USER)
		.then()
//			.statusCode(200)
			.log().all()
			.spec(resSpecObject);
	}
	
	
	public void waitForUserCreation(int maxWaitSeconds) throws InterruptedException {
	    int waited = 0;
	    while (waited < maxWaitSeconds) {
	        int statusCode = given()
	            .spec(reqSpecObject)
	            .pathParam("username", userName)
	        .when()
	            .get(UserEndPoints.GET_USER)
	        .getStatusCode();

	        if (statusCode == 200) break; // user exists, continue
	        Thread.sleep(1000);
	        waited++;
	    }
	}

}
