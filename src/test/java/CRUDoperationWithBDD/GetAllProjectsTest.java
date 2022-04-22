package CRUDoperationWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllProjectsTest 
{
	@Test
	public void getProjects()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		//Perform Action
		when()
			.get("/projects")
			
		//Validate Response
		.then()
			.contentType(ContentType.JSON)
			.log().all();
			
		
	}

}
