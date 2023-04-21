package practice;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.HomePage;
import POM.LoginPage;
import POM.ProductCreationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
//Without using Webtable deleting the product from the navigation page itself

public class CreateProdDeleteProd {

/*Scenario: Login to vtiger application-> Click on 'Products'-> Click on '+' sign-> Enter Product Name
 * Click on [Save]-> Navigated to Products Page wherein the newly saved product details are displayed 
 * Validate if the Header in the page contains the name of the Product created-> 
 * Click on [Delete]-> click on [OK] in Alert Popup-> In Products page we can see that the product is not there*/

	public static void main(String[] args) throws Throwable {

		Property_Utility plib = new Property_Utility();		//object creation of Property_Utility class
		String BROWSER = plib.getKeyValue("browser");		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("edge"))			
				{
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				}
		else if(BROWSER.equalsIgnoreCase("chrome"))		
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
		else if(BROWSER.equalsIgnoreCase("firefox"))		
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}
		else
				{
					driver = new EdgeDriver();		
				}
		
		Webdriver_Utility wlib = new Webdriver_Utility();  //object creation of Webdriver_Utility class
		wlib.maximizeWindow(driver);
		wlib.implicitWait(driver);

		//LoginPage
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		driver.get(URL);
		LoginPage loginPage = new LoginPage(driver);		//using POM class LoginPage
		loginPage.loginToApp(USERNAME, PASSWORD);
		
		//HomePage
		HomePage homePage = new HomePage(driver);			//using POM class HomePage
		homePage.clickProductsLinkText();
		
		//Products Page
		ProductCreationPage prod = new ProductCreationPage(driver);
		prod.clickProductCreateImage();
		
		//Creating New Product page
		Java_Utility jlib = new Java_Utility();		//object creation of Java_Utility class
		int RanNum = jlib.getRandomNum();		//calling getRandomNum() function to get random number	
		Excel_Utility elib = new Excel_Utility();   //object creation of Excel_Utility class
		String prod_name = elib.getExcelData("Products", 0, 0)+RanNum;	
		prod.productNameTextField(prod_name);;		//using POM class ProductCreationPage
		prod.clickSaveButton();
		
		//Product information page
		String act_prod_name = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
		 if(act_prod_name.contains(prod_name))
		 {
			 System.out.println("validation pass for "+ prod_name);		//validation pass
			 driver.findElement(By.name("Delete")).click();
			 Alert alt = driver.switchTo().alert();		//to switch focus to Alert pop-up
			 Thread.sleep(2000);
			 alt.accept();	//to select [OK]
			 System.out.println("Product "+ prod_name +" deleted");
		 }
		 else
		 {
			 System.out.println("validation fail for "+ prod_name);		//validation fail
		 }
		
		 
		 //Signout		 
		 homePage.clickSignOutLinkText(driver);		//using POM class HomePage
		 
	}

}


