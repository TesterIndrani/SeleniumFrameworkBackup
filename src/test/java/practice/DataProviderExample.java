package practice;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

	@Test(dataProvider = "dataProvider")	//give method name of dataProvider here
	public void BookTickets(String src, String des)	//DataSets {1st: [0][0]-[0][1], 2nd: [1][0]-[1][1], 3rd:[2][1]-[2][2]}
	{
		System.out.println("Book tickets from " + src + " to " + des);
	}
	
	@DataProvider
	public Object[][] dataProvider()		//return type is 2 dimensional array of Object type
	{
		Object[][] objarr = new Object[3][2];
		
		objarr[0][0] = "Bangalore";
		objarr[0][1] = "Goa";

		objarr[1][0] = "Bangalore";
		objarr[1][1] = "Mysore";
		
		objarr[2][0] = "Bangalore";
		objarr[2][1] = "Hyderabad";
	
	return objarr;		
	}
	
}
