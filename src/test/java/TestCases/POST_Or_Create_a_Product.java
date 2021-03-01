package TestCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class POST_Or_Create_a_Product {
	SoftAssert softAssert=new SoftAssert();
	@Test
	public void creat_a_Product() {
	HashMap payload =new HashMap();
	payload.put("name", "HPP LLaptop");
	payload.put("description", "Super Fast");
	payload.put("price", "$1100");
	payload.put("category_id", "2");
	payload.put("category_name", "Electronics");
	
	
		Response response=
		given()
		
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type", "application/json; charset=UTF-8")
			.body(payload)

		.when()
			.post("/create.php")
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
		Assert.assertEquals(js.get("message"), "Product was created.");
		
//		

}
}
