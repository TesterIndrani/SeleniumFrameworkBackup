package Generic_Utility;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerExample implements ITestListener {	 
	//overriding abstract method 'onTestFailure' of ITestListener interface
	public void onTestFailure(ITestResult result) {	//this method is called on failure of a test script

		String testName = result.getMethod().getMethodName();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);	//creating object to take screenshot
		File src = edriver.getScreenshotAs(OutputType.FILE);	
		//try-catch is being used for handling exception in any case
		try {	
			FileUtils.copyFile(src, new File("./ScreenShot/"+testName+".png"));	
			} catch(Exception e)
				{
					e.printStackTrace();
				}	
	}

	
}
