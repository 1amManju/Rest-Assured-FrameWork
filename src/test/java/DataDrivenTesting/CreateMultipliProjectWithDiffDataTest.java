package DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonLibraries.JavaUtils;
import ProjectLibraries.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateMultipliProjectWithDiffDataTest 
{
	@Test(dataProvider = "getData")
	public void createProject(String createdBy , String projectName , String status , int teamSize)
	{
		
		JavaUtils jLib = new JavaUtils();
		ProjectLibrary pLib = new ProjectLibrary(createdBy, projectName+jLib.getRandomNo(), status, teamSize);
		
		baseURI = "http://localhost";
		port = 8084;
		
		given()
			.body(pLib)
			.contentType(ContentType.JSON)
			
		.when()
			.post("/addProject")
			
		.then()
			.log().all();
		
		
	}

	@DataProvider(name = "getData")
	public Object[][] data()
	{
		Object data[][] = new Object[2][4];
		
		data[0][0] = "Manju";
		data[0][1] = "Amdocs";
		data[0][2] = "Created";
		data[0][3] = 12;
		
		data[1][0] = "Manju";
		data[1][1] = "Apple";
		data[1][2] = "Created";
		data[1][3] = 7;
		
		return data;
	}
	
}
