package com.assignmentapiproject;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FirstQuestionRestAssured {
	
	@Test
	public void firstMethodGet()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		//given().queryParam("status","available").get("/pet/findByStatus").then().log().all();
		Response res = RestAssured.given().when().get("/store/inventory");
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().asPrettyString());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.getHeaders());
	}
	@Test
	public void firstMethodGet2()
	{
		  RestAssured.baseURI = "https://reqres.in/api";
		  given().queryParam("page", "1") .when() .get("/users") .then().log().all()
		  .assertThat() .statusCode(200) .body("page", equalTo(1))
		  .body("data.first_name", hasItems("George", "Tracey", "Charles"))
		  .body("total", greaterThan(10));
	}
	
	@Test
	public void secondRestAssuredMethodPost()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Map<String,String> bodyDataMap = new HashMap<String,String>();
		bodyDataMap.put("id", "0");
		bodyDataMap.put("petId", "0");
		bodyDataMap.put("quantity", "0");
		bodyDataMap.put("shipDate", "2022-04-27T13:00:55.720Z");
		bodyDataMap.put("status", "placed");
		
		given().contentType("application/json").body(bodyDataMap)
		.when().log().all()
		.post("/store/order").then().assertThat().statusCode(200).log().body();
	}
	
	@Test
	public void thirdRestAssuredMethodPut()
	{
		Response res = given().when().get("https://jsonplaceholder.typicode.com/users").then()
				.contentType(ContentType.JSON).extract().response();
		String username = res.jsonPath().get("username[5]").toString();
		System.out.println(username);
		
		RestAssured.baseURI = "https://reqres.in/api";
		  
		UserPojo userPojo = new UserPojo(username,"Automation test specialist");
		given().body(userPojo).when().log()
		.body().put("/users/2")
		.then().assertThat().statusCode(200)
		.log().body();
	}
	
	@Test
	public void fourthRestAssuredMethodDelete()
	{
		RestAssured.baseURI = "https://reqres.in/api";
		
		given().when().delete("/users/2").then().assertThat().statusCode(204).log().all();
	}

}
