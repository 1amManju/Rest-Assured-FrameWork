package CRUDoperationWithoutBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import CommonLibraries.JavaUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CreateProjectTest 
{
	@Test
	public void createProject()
	{
		JavaUtils jLib = new JavaUtils();
		//Create the pre requisits
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Manju");
		jObj.put("projectName", "ICICI_"+jLib.getRandomNo());
		jObj.put("status", "Up-Coming");
		jObj.put("teamSize", 14);
		
		
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		//Perform The Action
		Response responce = req.post("http://localhost:8084/addProject");
		
		//Validate the response
		System.out.println(responce.getContentType());
		System.out.println(responce.asString());
		System.out.println(responce.prettyPrint());
		System.out.println(responce.prettyPeek());
		
		
		
		
	}

}
