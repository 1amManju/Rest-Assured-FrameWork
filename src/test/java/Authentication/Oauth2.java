package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2 
{
	@Test
	public void oauth2()
	{
		//Create a request to generate access token
		Response resp = given()
			.formParam("client_id", "SDET30-Oauth")
			.formParam("client_secret", "415891baa9e9ee46718cb1ca47ebe70f")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "http://manju.com")
			.formParam("code", "authorization_code")
			
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		
		//Capture token 
		String token=resp.jsonPath().get("access_token");
		System.out.println(token);
		
		//Create another req and use token
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID", 3122)
			
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
			
		.then()
			.log().all();
		
		
	}

}
