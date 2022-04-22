package DifferentWaysToPOST;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJSONfileTest 
{

	@Test
	public void createProject()
	{
		File file = new File("./Data.json");
		
		baseURI = "http://localhost";
		port = 8084;
		
		given()
			.body(file)
			.contentType(ContentType.JSON)
			
		.when()
			.post("/addProject")
			
		.then()
			.assertThat()
			.statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
			
			
		
	}
}
