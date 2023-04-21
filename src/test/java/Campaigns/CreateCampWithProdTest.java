package Campaigns;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import POM.CampaignCreationPage;
import POM.CampaignInformationPage;
import POM.HomePage;
import POM.LoginPage;
import POM.ProductCreationPage;
import POM.ProductsPopupPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/*Scenario: Login to vtiger application-> Click on 'Products'-> Click on '+' sign-> Enter Product Name
 * Click on [Save]-> Click on 'More'-> Click on 'Campaigns'-> Click on '+' sign-> Enter Campaign Name->
 * Click on '+' sign beside 'Product' textfield-> 'Products & action' window pop-up is opened
 * -> switch to that pop-up-> click on 'Search' textfield and pass Product name created just now-> 
 * Click on [Search Now]-> In the search result, click on the product name-> switch back to campaign creation page
 * -> click on [Save]-> Navigated to Campaign information page-> validate campaign name and product name
-> Signout */

public class CreateCampWithProdTest extends BaseClass {
	@Test(groups = "regressiontest")
	public void createCampWithProdTest() throws Throwable {
		
		Webdriver_Utility wlib = new Webdriver_Utility();	//object creation of Webdriver_Utility class
		wlib.maximizeWindow(driver);
		wlib.implicitWait(driver);
		HomePage homePage = new HomePage(driver);			//using POM class HomePage
		homePage.clickProductsLinkText();
		ProductCreationPage prod = new ProductCreationPage(driver);
		prod.clickProductCreateImage();
		Java_Utility jlib = new Java_Utility();		//object creation of Java_Utility class
		int RanNum = jlib.getRandomNum();		//calling getRandomNum() function to get random number
		Excel_Utility elib = new Excel_Utility();   //object creation of Excel_Utility class
		String prod_name = elib.getExcelData("Products", 0, 0)+RanNum;		
		prod.productNameTextField(prod_name);
		prod.clickSaveButton();
		homePage.clickMoreLinkText(driver);			//using POM class HomePage
		homePage.clickCampainsLinkText();
		CampaignCreationPage camp = new CampaignCreationPage(driver);	//using POM class CampaignCreationPage
		camp.clickCampaignCreateImage();
		String camp_name = elib.getExcelData("Campaigns", 0, 0)+RanNum;		
		camp.campaignNameTextField(camp_name);			//using POM class CampaignCreationPage
		camp.clickAddProductSign();
		wlib.switchWindow(driver, "Products&action");
		ProductsPopupPage popup = new ProductsPopupPage(driver);		//using POM class ProductsPopupPage
		popup.searchTextField(prod_name);
		popup.clickSearchNowButton();
		driver.findElement(By.xpath("//a[text()='"+prod_name+"']")).click();  //using dynamic xpath by concatenating dynamic product name
		wlib.switchWindow(driver, "Campaigns&action");
		camp.clickSaveButton();			//using POM class CampaignCreationPage
		CampaignInformationPage validate = new CampaignInformationPage(driver);	//using POM class CampaignInformationPage
		String act_camp_name = validate.campaignValidation(driver, camp_name);	
		Assert.assertEquals(act_camp_name, camp_name);
		String act_prod_name = validate.productValidation(driver, prod_name);
		Assert.assertEquals(act_prod_name, prod_name);
	}

}
