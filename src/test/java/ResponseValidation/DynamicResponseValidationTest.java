package ResponseValidation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponseValidationTest 
{
	@Test
	public void dynamicResonse()
	{
		
		String expData = "Amdocs";
		baseURI = "http://localhost";
		port = 8084;
		
		
			
		Response resp = when()
			.get("/projects");
		
		//Validation
		boolean flag = false;
		List<String> pIds=resp.jsonPath().get("projectName");
		for (String actData : pIds) 
		{
			if(actData.contains(expData))
			{
				flag = true;
			}
		}
		
		Assert.assertTrue(flag);
		System.out.println("Data Verified");
		
		
		resp.then().log().all();
		
	}

}
