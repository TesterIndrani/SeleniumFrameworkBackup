package Organizations;
import java.io.FileInputStream;
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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.CampaignCreationPage;
import POM.CampaignInformationPage;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationCreationPage;
import POM.OrganizationInformationPage;
import POM.ProductCreationPage;
import POM.ProductInformationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/*Scenario: Login to vtiger application-> Click on Organizations-> Click on '+' sign-> Enter Organization Name
 * Click on [Save]-> Navigated to Organizations Page wherein the newly saved organization details are displayed 
 * Validate if the Header in the page contains the name of the Organization created-> Signout*/

//@Listeners(Generic_Utility.ITestListenerExample.class)
public class CreateOrganizationTest extends BaseClass {		
	//@Test(retryAnalyzer = Generic_Utility.IRetryAnalyzerExample.class) 
	@Test(groups = {"smoketest","regressiontest","sanitytest"})						
	public void createOrganizationTest() throws Throwable {
		
		Webdriver_Utility wlib = new Webdriver_Utility();   //object creation of Webdriver_Utility class
		wlib.maximizeWindow(driver);
		wlib.implicitWait(driver);
		HomePage homePage = new HomePage(driver);			//using POM class HomePage
		homePage.clickOrganizationsLinkText();	
//		Assert.assertEquals(false, true);		//to fail assert intentionally for Listeners
		OrganizationCreationPage org = new OrganizationCreationPage(driver);	//using POM class OrganizationCreationPage
		org.clickOrganizationCreateImage();
		Java_Utility jlib = new Java_Utility();		//object creation of Java_Utility class
		int RanNum = jlib.getRandomNum();		
		Excel_Utility elib = new Excel_Utility();   //object creation of Excel_Utility class
		String org_name = elib.getExcelDataFormatter("Organizations", 2, 1)+RanNum;	
		org.organizationNameTextField(org_name);		//using POM class OrganizationCreationPage
		org.clickSaveButton();
		OrganizationInformationPage validate = new OrganizationInformationPage(driver); //using POM class OrganizationInformationPage
		String act_org_name = validate.organizationValidation(driver, org_name);	//getting the actual name to use in Assert
		Assert.assertEquals(act_org_name, org_name);		//Assertion required even after validation	
		}
}