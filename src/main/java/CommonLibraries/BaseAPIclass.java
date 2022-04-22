package CommonLibraries;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPIclass 
{
	
	public DatabaseLibraries dLib = new DatabaseLibraries();
	public JavaUtils jLib = new JavaUtils();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		//Establish Database Connection
		dLib.connectToDataBase();
		System.out.println("========= DB Connection Established ===========");
		
		//Set base uri and port
		baseURI = "http://localhost";
		port = 8084;
	}
	
	@AfterSuite
	public void asConfg() throws Throwable
	{
		dLib.closeDataBase();
	}

}
