package CRUDoperationWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeletePerticularProjectTest 
{
	@Test
	public void deleteProject()
	{
		//Perform Action
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_202");
		
		//Validate the Response  
		int dlt = resp.getStatusCode();
		Assert.assertEquals(204, dlt);
	}

}
