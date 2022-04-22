package ResponseValidation;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValdationTest 
{
	@Test
	public void responseTime()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		Response resp = when()
			.get("/projects");
		
		Assert.assertTrue(resp.time()<4000);
			
		resp.then()
			.assertThat()
			.time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS)
			.log().all();
		
		long val = resp.time();
		System.out.println("Response Time => "+val);
	
	}

}
