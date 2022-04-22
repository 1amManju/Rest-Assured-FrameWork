package CRUDoperationWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteProjectTest 
{
	@Test
	public void getPerticularProject()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		//Perform Action
		when()
			.delete("/projects/TY_PROJ_631")
			
		//Validate the Response
		.then()
			.statusCode(204)
			.contentType(ContentType.JSON);
	}

}
