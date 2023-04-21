package Products;
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
import POM.ProductCreationPage;
import POM.ProductInformationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/*Scenario: Login to vtiger application-> Click on 'Products'-> Click on '+' sign-> Enter Product Name
 * Click on [Save]-> Navigated to Products Page wherein the newly saved product details are displayed 
 * Validate if the Header in the page contains the name of the Product created-> Signout */

public class CreateProductTest extends BaseClass{
	@Test
	public void createProductTest() throws Throwable {
				
		Webdriver_Utility wlib = new Webdriver_Utility();   //object creation of Webdriver_Utility class
		wlib.maximizeWindow(driver);
		wlib.implicitWait(driver);
		HomePage homePage = new HomePage(driver);			//using POM class HomePage
		homePage.clickProductsLinkText();
		ProductCreationPage prod = new ProductCreationPage(driver);		//using POM class ProductCreationPage
		prod.clickProductCreateImage();
		Java_Utility jlib = new Java_Utility();		//object creation of Java_Utility class
		int RanNum = jlib.getRandomNum();		//calling getRandomNum() function to get random number
		Excel_Utility elib = new Excel_Utility();   //object creation of Excel_Utility class
		String prod_name = elib.getExcelData("Products", 0, 0)+RanNum;	
		prod.productNameTextField(prod_name);		//using POM class ProductCreationPage
		prod.clickSaveButton();
		Thread.sleep(2000);
		ProductInformationPage validate = new ProductInformationPage(driver);	//using POM class ProducInformationPage			 
		String act_prod_name = validate.productValidation(driver, prod_name);	
		Assert.assertEquals(prod_name, act_prod_name);		
	}

}
