package CRUDoperationWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetPerticularProjectTest 
{
	@Test
	public void getPerticularProject()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		//Perform Action
		when()
			.get("/projects/TY_PROJ_631")
			
		//Validate the Response
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.log().all();
	}

}
