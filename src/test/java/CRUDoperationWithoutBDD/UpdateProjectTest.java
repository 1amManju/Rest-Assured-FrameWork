package CRUDoperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest 
{
	@Test
	public void createProject()
	{
		//Create the pre requisits
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Manju");
		jObj.put("projectName", "SONY");
		jObj.put("status", "Complected");
		jObj.put("teamSize", 5);
		
		
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		//Perform The Action
		Response responce = req.put("http://localhost:8084/projects/TY_PROJ_1003");
		
		//Validate the response
		System.out.println(responce.getContentType());
		System.out.println(responce.asString());
		System.out.println(responce.prettyPrint());
		System.out.println(responce.prettyPeek());
		
		
		
		
	}

}
