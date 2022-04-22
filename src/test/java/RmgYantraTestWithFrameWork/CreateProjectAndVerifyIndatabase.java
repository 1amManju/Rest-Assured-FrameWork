package RmgYantraTestWithFrameWork;

import CommonLibraries.BaseAPIclass;
import CommonLibraries.EndPointsLibrary;
import ProjectLibraries.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class CreateProjectAndVerifyIndatabase extends BaseAPIclass
{
	@Test
	public void createProjectAndVerifyInDatabase() throws Throwable
	{
		ProjectLibrary pLib = new ProjectLibrary("Manjunath", "Amdocs_"+jLib.getRandomNo(), "On-Going", 22);
		
		//Create Pre-requisites
		Response resp = given()
							.body(pLib)
							.contentType(ContentType.JSON)
						.when()
							.post(EndPointsLibrary.CreateProject);
		
		//Capture the Project Id
		String expData = rLib.getJsoPath(resp, "projectId");
		System.out.println(expData);
		
		//Verify the Project in Api Response
		given()
			.pathParam("pid", expData)
		.when()
			.get(EndPointsLibrary.Getallproject+"/{pid}")
		.then().log().all();
		System.out.println("Data Verified in API Response");
		
		
		//Verify the Project in Database
		String query = "Select * from project";
		dLib.executeQueryAndGetData(query, 1, expData);
		System.out.println("Data Verified sucessfully in Database");
		
	}

}
