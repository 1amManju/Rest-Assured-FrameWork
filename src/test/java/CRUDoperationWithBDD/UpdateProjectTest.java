package CRUDoperationWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProjectTest 
{
	@Test
	public void createProject()
	{
		//Create the pre requisits
				JSONObject jObj = new JSONObject();
				jObj.put("createdBy", "Manju");
				jObj.put("projectName", "HDFC");
				jObj.put("status", "On-Going");
				jObj.put("teamSize", 7);
				
				baseURI = "http://localhost";
				port = 8084;
				
				given()
				  .body(jObj)
				  .contentType(ContentType.JSON)
		//Perform Action		  
				.when()
				   .put("/projects/TY_PROJ_1004")
		//Validate the Response		   
				.then()
				   .assertThat()
				   .contentType(ContentType.JSON)
				   .log().all();
				
				
	}

}
