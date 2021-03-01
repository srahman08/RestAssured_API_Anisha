package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GET_Or_Read_One_Product {
	SoftAssert softAssert=new SoftAssert();
	@Test
	public void read_One_Products(String idvalue) {
		Response response=
		given()
		
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type", "application/json; charset=UTF-8")
			.queryParams("id", idvalue)
		.when()
			.get("/read_one.php")
		.then()
			.extract().response();
		
		
		
//		int stsuscode = response.getStatusCode();
//		System.out.println("This is a status code "+ stsuscode);
//		//Assert.assertEquals(stsuscode, 200);
//		softAssert.assertEquals(stsuscode, 201, "Status code doesnotMATCH");
//		
		response.getBody().prettyPrint();
//		String responseBody= response.getBody().asString();
//		//System.out.println(responseBody);
//		//Parsing the response body to json:
//		JsonPath js= new JsonPath(responseBody);
//		String productId = js.getString("id");
//		String productname = js.getString("name");
//		
//		Assert.assertEquals(productId, "1209");
//		Assert.assertEquals(productname, "HP Laptop Elite Pro");
//		
//		System.out.println("+++++" +productId);
//		
		//System.out.println(js);
				//js.prettyPrint();
		
//		long time= response.getTimeIn(TimeUnit.MILLISECONDS);
//		System.out.println(time);
//		if (time<=1000){
//			System.out.println("The response time of Acceptable");}
//			else {
//				System.out.println("NOT Acceptable");
//			}
		
	}

	}

/*
 * Base URL/URI, Endpoint/Resource, Headers, QueryParameters 
 * Http Methods: GET,POST,PUT,DELETE Payload/Body
 * given: all input details (Base URL/URI, Headers, Payload/Body,
 * QueryParameters) when: Submit api requests (http
 * methods(GET/POST/PUT/DELETE), endpoint/resource) then: validate the
 * response(statusCode,Headers, Payload/Body, responseTime)
 */
// https://techfios.com/api-prod/api/product/read.php
	


