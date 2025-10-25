package com.petStore.store;

import org.testng.annotations.Test;

import com.PetStore.BaseAPIClass.BaseAPIClass;

import iEndPoints.StoreEndPoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class StoreOperations extends BaseAPIClass{
	
	
	@Test
	public void getInventory()
	{
		given()
		.spec(reqSpecObject)
		.basePath(StoreEndPoints.GET_INVENTORY)
		.get()
		.then()
		.assertThat().statusCode(200)
		.spec(resSpecObject)
		.log().all();
		
	}
	
	@Test
	public void placeOrder()
	{
		
	}
	
}
