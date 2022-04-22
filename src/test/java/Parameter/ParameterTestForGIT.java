package Parameter;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

public class ParameterTestForGIT 
{
	@Test
	public void parameterTest()
	{
		baseURI = "https://api.github.com";
		
		given()
			.pathParam("username", "1amManju")
			.queryParam("per_page", 45)
			.queryParam("page", 3)
			
		.when()
			.get("/users/{username}/repos")
			
		.then()  
			.statusCode(200).log().all();
		
		
		
		
	}

}
