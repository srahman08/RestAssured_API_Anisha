package TestCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Put_Update {
	SoftAssert softAssert = new SoftAssert();
	GET_Or_Read_One_Product readAprod= new GET_Or_Read_One_Product();

	@Test
	public void update_a_Product() {
		HashMap payload = new HashMap();
		payload.put("id", "1305");
		payload.put("name", "HHarry Potter 7");
		payload.put("description", "FICTION.");
		payload.put("price", "100");
		payload.put("category_id", "4");
		payload.put("category_name", "Book");

		Response response = 
			
				given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type", "application/json; charset=UTF-8").body(payload)

				.when()
					.post("/update.php")
				.then()
					.extract().response();

		int stsuscode = response.getStatusCode();
		System.out.println("=+=+=+=" + response.getHeaders());
		System.out.println("This is a status code " + stsuscode);
		// Assert.assertEquals(stsuscode, 200);
		softAssert.assertEquals(stsuscode, 201, "Status code NOT MATCH");

		// response.getBody().prettyPrint();
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		// Parsing the response body to json:
		JsonPath js = new JsonPath(responseBody);
		String messageValue= js.getString("message");
		Assert.assertEquals(messageValue, "Product was updated.", "SOmething Wrong..");
		//Assert.assertEquals(js.get("message"), "Product was updated.");
		
		readAprod.read_One_Products("1305");

//		

	}

}
