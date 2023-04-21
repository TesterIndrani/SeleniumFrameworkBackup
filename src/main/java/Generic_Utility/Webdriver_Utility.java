package Generic_Utility;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import java.util.Date;

public class Webdriver_Utility {
/**
 * This method implements wait for page to load in GUI
 * @param driver
 * @author Indrani
 */
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}	

/**
 * This method is used to maximize the window
 * @author Indrani
 * @param driver
 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

/**
 * this method is used to switch windows
 * @author Indrani	
 * @param driver
 * @param PartialWindowTitle
 */
	public void switchWindow(WebDriver driver, String PartialWindowTitle) 
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> id = allId.iterator();		//using iterator from Collection
		
		while(id.hasNext())			//checking if more than one window is open currently
		{
			String wid = id.next();		//get window id of next window
			driver.switchTo().window(wid);		//switch to next window
			String title = driver.getTitle();		//get title
		
			if(title.contains(PartialWindowTitle))		//checking for the popup window with the list of products
			{
				break;
			}
		}
		
	}
	
	
	/**
	 *After every action it will wait for next action to perform
	 * @author Indrani
	 */
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(20));		
	}

	/**
	 * used to wait for element to be clickable in GUI and check for specific element for every 500 milliseconds
	 * @author Indrani
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement Element,int pollingTime)
	{
		FluentWait wait=new FluentWait(driver);
	    wait.pollingEvery(Duration.ofSeconds(20));	
	    wait.until(ExpectedConditions.elementToBeClickable(Element));
	}


	/**
	 *used to switch to AlertWindow and Accept(click on ok Button) 
	 *@param driver
	 *@author Indrani 
	 */
	public void switchToAlertAndAccpect(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	/**
	 * used to switch to AlertWindow and dismiss(click on Cancel Button)
	 *  @param driver
	 * @author Indrani
	 */
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to switch to frame window based on Index
	 * @param driver
	 * @param index
	 * @author Indrani
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
		}
	/**
	 * 
	 * used to switch to frame window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 * @author Indrani
	 */
	public void switchToFrame(WebDriver driver,String id_name_Attribute)
	{
	driver.switchTo().frame(id_name_Attribute);	
	}
	/**
	 * used to select the value from the dropDown based on index
	 * @param element
	 * @param index
	 * @author Indrani
	 */
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropDown based on text
	* @param element
	 * @param text
	 * @author Indrani
	 */
	public void select(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 * @author Indrani
	 * 
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	/**
	 * used to right click on specific element
	 * @param driver
	 * @param element
	 * @author Indrani
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void moveByOffest(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}
	public  String takeScreenshot(WebDriver sDriver, String methodName) {
		Date date=new Date();
		date.toString().replace(" "," ").replace(":","-");
		//TakesScreenshot ts=(TakesScreenshot)driver;
		return null;
	}

	
}
