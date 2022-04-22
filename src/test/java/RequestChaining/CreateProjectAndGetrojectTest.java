package RequestChaining;

import org.testng.annotations.Test;

import CommonLibraries.JavaUtils;
import ProjectLibraries.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectAndGetrojectTest 
{
	@Test
	public void createProjectAndGetroject()
	{
		JavaUtils jLib = new JavaUtils();
		ProjectLibrary pLib = new ProjectLibrary("Swathi", "Salaga_"+jLib.getRandomNo(), "Created", 100);
		baseURI ="http://localhost";
		port = 8084;
		
		Response resp = given()
			.body(pLib)
			.contentType(ContentType.JSON)
		.when()
			.post("/addProject");
		
		String proId = resp.jsonPath().get("projectId");
		resp.then().log().all();
		
		given()
			.pathParam("pid", proId)
		.when()
			.get("/projects/{pid}")
		.then()
			.assertThat().statusCode(200)
			.log().all();
		
		
	}

}
