package Generic_Utility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzerExample implements IRetryAnalyzer{

	int count=0;
	int retryLimit=2;
	
	public boolean retry(ITestResult result) 
	{
		if(count<retryLimit)	//will execute the method 5 times (1+retryLimit)
		{
			count++;
			return true;
		}
		return false;
	}
}
