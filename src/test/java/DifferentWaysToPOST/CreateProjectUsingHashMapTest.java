package DifferentWaysToPOST;

import org.testng.annotations.Test;

import CommonLibraries.JavaUtils;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectUsingHashMapTest 
{
	@Test
	public void createProject()
	{
		JavaUtils jLib = new JavaUtils();
		
		HashMap hm = new HashMap();
		hm.put("createdBy", "Manjunath");
		hm.put("projectName", "SONY_"+jLib.getRandomNo());
		hm.put("status", "Up-Coming");
		hm.put("teamSize", 5);
		
		baseURI = "http://localhost";
		port = 8084;
		
		given()
			.body(hm)
			.contentType(ContentType.JSON)
			
		.when()
			.post("/addProject")
			
		.then()
			.assertThat()
			.statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}

}
