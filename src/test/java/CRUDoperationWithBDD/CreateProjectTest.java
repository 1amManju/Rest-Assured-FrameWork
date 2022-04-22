package CRUDoperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import CommonLibraries.JavaUtils;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectTest 
{
	@Test
	public void createProject()
	{  
		JavaUtils jLib = new JavaUtils();
		//Create the pre requisits
				JSONObject jObj = new JSONObject();
				jObj.put("createdBy", "Manju");
				jObj.put("projectName", "HDFCBank_"+jLib.getRandomNo());
				jObj.put("status", "Up-Coming");
				jObj.put("teamSize", 7);
				
				baseURI = "http://localhost";
				port = 8084;
				
				given()
				  .body(jObj)
				  .contentType(ContentType.JSON)
		//Perform Action		  
				.when()
				   .post("/addProject")
		//Validate the Response		   TY_PROJ_1004
				.then()
				   .assertThat()
				   .statusCode(201)
				   .contentType(ContentType.JSON)
				   .log().all();
				
				
	}

}
