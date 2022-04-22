package DifferentWaysToPOST;

import org.testng.annotations.Test;

import CommonLibraries.JavaUtils;
import ProjectLibraries.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPOJOclassTest 
{
	@Test
	public void createProject()
	{
		JavaUtils jLib = new JavaUtils();
		
		baseURI = "http://localhost";
		port = 8084;
		
		ProjectLibrary pLib = new ProjectLibrary("Manju", "APPLE"+jLib.getRandomNo(), "Complected", 3);
		
		given()
		.body(pLib)
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
