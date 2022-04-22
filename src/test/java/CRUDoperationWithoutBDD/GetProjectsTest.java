package CRUDoperationWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetProjectsTest 
{
	@Test
	public void getAllroject()
	{
		//Perform Action
		Response response = RestAssured.get("http://localhost:8084/projects");
		
		//Validate the response
		response.then().log().all();
		int cd = response.getStatusCode();
		Assert.assertEquals(200, cd);
		
		
	}
}
