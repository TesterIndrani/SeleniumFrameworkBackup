package Generic_Utility;
import java.util.Random;

public class Java_Utility		//user defined class
{
	/**
	 * This method is used to avoid duplicates
	 * @author Indrani
	 * @return
	 */
	public int getRandomNum()		//non-static method for generating random number
	{
		Random r = new Random();
		int RanNum = r.nextInt(1000);
		return RanNum;
	}
}
