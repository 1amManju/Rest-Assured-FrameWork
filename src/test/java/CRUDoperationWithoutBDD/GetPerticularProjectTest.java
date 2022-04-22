package CRUDoperationWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetPerticularProjectTest 
{
	@Test
	public void deleteProject()
	{
		//Perform Action
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_403");
		
		//Validate the Response  TY_PROJ_403
		resp.then().log().all();
		int dlt = resp.getStatusCode();
		Assert.assertEquals(200, dlt);
	}
}
