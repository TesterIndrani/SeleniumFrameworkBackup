package Campaigns;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationCreationPage;
import POM.ProductInformationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import POM.CampaignCreationPage;
import POM.CampaignInformationPage;

/*Scenario: Login to vtiger application-> Click on 'More'-> Click on 'Campaigns'-> Click on '+' sign-> 
 * Enter Campaign Name-> Click on [Save]-> Navigated to Campaigns Page wherein the newly saved campaign details 
 * are displayed-> Validate if the Header in the page contains the name of the campaign created-> Signout */

public class CreateCampaignTest extends BaseClass {
	@Test(groups = {"smoketest"})						
	public void createCampaignTest() throws Throwable {
		
		Webdriver_Utility wlib = new Webdriver_Utility();    //object creation of Webdriver_Utility class
		wlib.maximizeWindow(driver);
		wlib.implicitWait(driver);
		HomePage homePage = new HomePage(driver);			//using POM class HomePage
		homePage.clickMoreLinkText(driver);
		homePage.clickCampainsLinkText();
		CampaignCreationPage camp = new CampaignCreationPage(driver);	//using POM class CampaignCreationPage
		camp.clickCampaignCreateImage();
		Java_Utility jlib = new Java_Utility();		//object creation of Java_Utility class
		int RanNum = jlib.getRandomNum();		//calling getRandomNum() function to get random number
		Excel_Utility elib = new Excel_Utility();   //object creation of Excel_Utility class
		String camp_name = elib.getExcelData("Campaigns", 0, 0)+RanNum;		
		camp.campaignNameTextField(camp_name);		//using POM class CampaignCreationPage
		camp.clickSaveButton();
		CampaignInformationPage validate = new CampaignInformationPage(driver);	//using POM class CampaignInformationPage
		String act_camp_name = validate.campaignValidation(driver, camp_name);	
		Assert.assertEquals(act_camp_name, camp_name);
	}
}
