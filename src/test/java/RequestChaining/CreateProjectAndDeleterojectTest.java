package RequestChaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import CommonLibraries.JavaUtils;
import ProjectLibraries.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectAndDeleterojectTest 
{
	@Test
	public void createProjectAndGetroject()
	{
		JavaUtils jLib = new JavaUtils();
		ProjectLibrary pLib = new ProjectLibrary("Swathi", "Salaga2_"+jLib.getRandomNo(), "Created", 10);
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
			.delete("/projects/{pid}")
		.then()
			.assertThat().statusCode(204)
			.log().all();
		
		
	}

}
