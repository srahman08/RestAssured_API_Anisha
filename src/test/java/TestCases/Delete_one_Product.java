package TestCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Delete_one_Product {
	SoftAssert softAssert=new SoftAssert();
	@Test
	public void creat_a_Product() {
	HashMap payload =new HashMap();
	payload.put("id", "1129");
	
	
	
		Response response=
		given()
		
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type", "application/json; charset=UTF-8")
			.body(payload)

		.when()
			.delete("/delete.php")
		.then()
			.extract().response();
		
		int stsuscode = response.getStatusCode();
		System.out.println("=+=+=+="+ response.getHeaders());
		System.out.println("This is a status code "+ stsuscode);
		//Assert.assertEquals(stsuscode, 200);
		softAssert.assertEquals(stsuscode, 201, "Status code NOT MATCH");
		
	//	response.getBody().prettyPrint();
		String responseBody= response.getBody().asString();
		System.out.println(responseBody);
		//Parsing the response body to json:
		JsonPath js= new JsonPath(responseBody);
		Assert.assertEquals(js.get("message"), "Product was DELETED.");
		
//		

}

}
