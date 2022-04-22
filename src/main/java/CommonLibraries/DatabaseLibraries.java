package CommonLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;

/**
 * This class contains all generic methods wrt DataBase
 * @author Manjunath
 *
 */
public class DatabaseLibraries 
{
	Connection con;
	/**
	 * This method will register to DtaBase
	 * @throws Throwable
	 */
	public void connectToDataBase() throws Throwable
	{
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(ConstantLibrary.JDBCpath, ConstantLibrary.DBUN, ConstantLibrary.DBPWD);
	}

	/**
	 * This method will close the DataBase
	 * @throws Throwable
	 */
	public void closeDataBase() throws Throwable
	{
		con.close();
	}

	/**
	 * This method will execute the query and return the matching Data to the user
	 * @param SQLquery
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String SQLquery ,int columnIndex, String expData) throws Throwable
	{
		String data = null;
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(SQLquery);
		while(result.next())
		{
			data = result.getString(columnIndex);
			if(data.equalsIgnoreCase(expData))
			{
				flag=true;//flag rising 
				break;
			}
		}
		if(flag)
		{
			System.out.println(data +"------>Data verified");
			return expData;
		}
		else
		{
			System.out.println(data + "------>Data not Verified");
			return "";
		}
	}

}
