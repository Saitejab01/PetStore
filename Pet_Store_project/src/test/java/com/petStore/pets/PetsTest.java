package com.petStore.pets;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.PetStore.BaseAPIClass.BaseAPIClass;

import POJO.util.Category;
import POJO.util.PetPojo;
import POJO.util.Tag;
import iEndPoints.IEndPointsOfPets;
import io.restassured.response.Response;

public class PetsTest extends BaseAPIClass{
	int id;
	PetPojo cPet;
	@Test
	public void createPetTest() {
		ArrayList<String> imgUrlList = new ArrayList<String>();
		imgUrlList.add("https://cdn.pixabay.com/photo/2025/05/23/06/35/sparrow-9617024_1280.jpg");
		imgUrlList.add("https://cdn.pixabay.com/photo/2022/04/21/06/44/louvre-7146800_640.jpg");
		imgUrlList.add("https://cdn.pixabay.com/photo/2025/10/02/15/18/sheikh-zayed-grand-mosque-9868660_640.jpg");
		ArrayList<Tag> tagList = new ArrayList<Tag>();
		tagList.add(new Tag(1, "puppy"));
		tagList.add(new Tag(2, "bull"));
		tagList.add(new Tag(3, "lollipop"));
		cPet = new PetPojo(jlib.getRandomNumber(), new Category(1, "doggy"), "ram_"+jlib.getRandomNumber(), imgUrlList, tagList, "available");
		Response resp = given()
		.spec(reqSpecObject)
		.body(cPet)
		.when()
		.post(IEndPointsOfPets.AddNewPetPost);
		resp.then()
		.spec(resSpecObject)
		.log()
		.all();
		id=resp.jsonPath().get("id");
	}
	
	@Test(dependsOnMethods = "createPetTest")
	public void getPetDetails() {
		given()
		.spec(reqSpecObject)
		.pathParam("petId", id)
		.when()
		.get(IEndPointsOfPets.FindPetIDGet)
		.then()
		.spec(resSpecObject)
		.log()
		.all();
	}
	
	@Test(dependsOnMethods = "getPetDetails")
	public void updateThePet() {
		cPet.setName("raju_"+jlib.getRandomNumber());
		given()
		.spec(reqSpecObject)
		.body(cPet)
		.when()
		.put(IEndPointsOfPets.UpdatePetPut)
		.then()
		.spec(resSpecObject)
		.log()
		.all();
	}
	
	@Test
	public void findPetByStatusTest() {
		given()
		.spec(reqSpecObject)
		.queryParam("status", "available")
		.when()
		.get(IEndPointsOfPets.FindPetStatusGet)
		.then()
		.spec(resSpecObject)
		.log()
		.all();
	}
	
	@Test(dependsOnMethods = "updateThePet")
	public void updatePetByIdTest() {
		given()
		.spec(reqSpecObject)
		.pathParam("petId", id)
		.formParam("name", "changed_"+jlib.getRandomNumber())
		.formParam("status", "pending")
		.when()
		.get(IEndPointsOfPets.UpdatePetByIDPost)
		.then()
		.spec(resSpecObject)
		.log()
		.all();
	}
	
	@Test(dependsOnMethods = "updateThePet")
	public void deletePetById() {
		given()
		.spec(reqSpecObject)
		.pathParam("petId", id)
		.when()
		.get(IEndPointsOfPets.deletePetByIDDelete)
		.then()
		.spec(resSpecObject)
		.log()
		.all();
	}
}
