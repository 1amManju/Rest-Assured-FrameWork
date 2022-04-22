package Authentication;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BearerToken 
{
	@Test
	public void bearerToken()
	{
		String token = "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";
		baseURI = "https://api.github.com";
		
		JSONObject jObj = new JSONObject();
		jObj.put("name", "SDET30-RestAssured");
		
		given()
			.auth().oauth2(token)
			.body(jObj)
			.contentType(ContentType.JSON)
		.when()
			.post("/user/repos")
		.then()
			.log().all();
		
	}

}
