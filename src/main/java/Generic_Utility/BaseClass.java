package Generic_Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import POM.HomePage;
import POM.LoginPage;

public class BaseClass {

	public static WebDriver sdriver;	//to use in ListenerClass as static variable
	public WebDriver driver;		//making driver public to be accessible by child classes

	@BeforeSuite(groups = {"smoketest","regressiontest","sanitytest"})
	public void BS()
	{
		System.out.println("Database connection");
	}
	
	@BeforeTest(groups = {"smoketest","regressiontest","sanitytest"})
	public void BT()
	{
		System.out.println("Parallel execution");
	}
		
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smoketest","regressiontest","sanitytest"})
//	public void BC(String BROWSER) throws Throwable
	public void BC() throws Throwable
	{
		Property_Utility plib = new Property_Utility();	
		String BROWSER = plib.getKeyValue("browser");		
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
		System.out.println("Launching browser");
		sdriver = driver;
	}
	
	@BeforeMethod(groups = {"smoketest","regressiontest","sanitytest"})
	public void BM() throws Throwable 
	{
		Property_Utility plib = new Property_Utility();		//object creation of Property_Utility class
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		driver.get(URL);
		LoginPage loginPage = new LoginPage(driver);		//using POM class LoginPage
		loginPage.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login Application");
	}
	
	@AfterMethod(groups = {"smoketest","regressiontest","sanitytest"})
	public void AM()
	{
		HomePage homePage = new HomePage(driver);	//using POM class HomePage
		homePage.clickSignOutLinkText(driver);	
		System.out.println("Logout Application");
	}
	
	@AfterClass(groups = {"smoketest","regressiontest","sanitytest"})
	public void AC()
	{
		driver.quit();
		System.out.println("Browser closed");
	}
	
	@AfterTest(groups = {"smoketest","regressiontest","sanitytest"})
	public void AT()
	{
		System.out.println("Parallel Execution done");
	}
	
	@AfterSuite(groups = {"smoketest","regressiontest","sanitytest"})
	public void AS()
	{
		System.out.println("Database connection close");
	}
	
}
