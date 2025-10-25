package com.petStore.store;

import org.testng.annotations.Test;

import com.PetStore.BaseAPIClass.BaseAPIClass;

import POJO.util.Category;
import POJO.util.PetPojo;
import POJO.util.StorePOJO;
import POJO.util.Tag;import genericUtilities.JavaUtil;
import iEndPoints.IEndPointsOfPets;
import iEndPoints.StoreEndPoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Date;

public class StoreOperations extends BaseAPIClass{
	
	int petId;
	int OrderId;
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
		ArrayList<String> imgUrlList = new ArrayList<String>();
		imgUrlList.add("https://cdn.pixabay.com/photo/2025/05/23/06/35/sparrow-9617024_1280.jpg");
		imgUrlList.add("https://cdn.pixabay.com/photo/2022/04/21/06/44/louvre-7146800_640.jpg");
		imgUrlList.add("https://cdn.pixabay.com/photo/2025/10/02/15/18/sheikh-zayed-grand-mosque-9868660_640.jpg");
		ArrayList<Tag> tagList = new ArrayList<Tag>();
		tagList.add(new Tag(1, "puppy"));
		tagList.add(new Tag(2, "bull"));
		tagList.add(new Tag(3, "lollipop"));
		PetPojo cPet = new PetPojo(jlib.getRandomNumber(), new Category(1, "doggy"), "ram", imgUrlList, tagList, "available");
		Response resp = given()
		.spec(reqSpecObject)
		.body(cPet)
		.when()
		.post(IEndPointsOfPets.AddNewPetPost);
		resp.then()
		.spec(resSpecObject)
		.log()
		.all();
		petId=resp.jsonPath().get("id");
		System.out.println(petId);
		
		OrderId=jlib.getRandomNumber();
		StorePOJO pojo=new StorePOJO(OrderId, petId, 1, new Date(), "placed", true);
		
		given()
		.spec(reqSpecObject)
		.basePath(StoreEndPoints.PLACE_AN_ORDER)
		.body(pojo)
		.when()
		.post()
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
	
	@Test(dependsOnMethods = "placeOrder")
	public void getParchaseDetails()
	{
		given()
		.spec(reqSpecObject)
		.basePath(StoreEndPoints.PURCHASE_DETAILS_BY_ORDER_ID)
		.pathParam("orderId", OrderId)
		.get()
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
	
	@Test(dependsOnMethods = "placeOrder")
	public void deleteParchaseDetails()
	{
		given()
		.spec(reqSpecObject)
		.basePath(StoreEndPoints.PURCHASE_DETAILS_BY_ORDER_ID)
		.pathParam("orderId", OrderId)
		.delete()
		.then()
		.assertThat().statusCode(404)
		.log().all();
	}
	
}
