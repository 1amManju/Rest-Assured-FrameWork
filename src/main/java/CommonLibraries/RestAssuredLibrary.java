package CommonLibraries;

import io.restassured.response.Response;

/**
 * This class consist of generic methods of rest assured
 * @author Manjunath
 *
 */
public class RestAssuredLibrary 
{
	 public String getJsoPath(Response resp , String JsonPath)
	 {
		 String value = resp.jsonPath().get(JsonPath);
		return value;
		 
	 }

}
