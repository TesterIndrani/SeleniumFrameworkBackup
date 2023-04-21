package practice;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Generic_Utility.Excel_Utility;

public class DataProviderUsingExcel {

	@Test(dataProvider = "getData")	//give method name of dataProvider here
	public void BookTickets(String src, String des)	//DataSets {1st: [0][0]-[0][1], 2nd: [1][0]-[1][1], 3rd:[2][1]-[2][2]}
	{
		System.out.println("Book tickets from " + src + " to " + des);
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable		//return type is 2 dimensional array of Object type
	{
		Excel_Utility elib = new Excel_Utility();
		Object[][] objarr = elib.readMultipleData("DataProvider");
		return objarr;
	}
}

