package com.petStore.store;

import org.testng.annotations.Test;

import com.PetStore.BaseAPIClass.BaseAPIClass;

import iEndPoints.StoreEndPoints;

import static io.restassured.RestAssured.*;

public class StoreOperations extends BaseAPIClass{
	
	
	@Test
	public void getInventory()
	{
		given()
		.spec(requestSpecification)
		.log().all()
		.get(StoreEndPoints.GET_INVENTORY)
		.then()
		.spec(responseSpecification)
		.assertThat().statusCode(200);
		
	}
	
}
