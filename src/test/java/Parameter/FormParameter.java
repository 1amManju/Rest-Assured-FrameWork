package Parameter;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameter 
{
	@Test
	public void formarameter()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		given()
			.formParam("createdBy", "Manjunath")
			.formParam("projectName", "Xylam")
			.formParam("status", "Created")
			.formParam("teamSize", 8)
			.contentType(ContentType.JSON)
			
		.when()
			.post("/addProject")
			
		.then()
			.log().all();
			
		
		
	}

}
