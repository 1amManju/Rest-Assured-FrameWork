package CommonLibraries;

import java.util.Random;

/**
 * This Class Contains Generic Methods of Java
 * @author Manjunath
 *
 */
public class JavaUtils 
{
	/**
	 * This method will generate Random no
	 * @return
	 */
	public int getRandomNo()
	{
		Random r = new Random();
		int random = r.nextInt(1000);
		return random;

	}

}
