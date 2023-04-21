package assignments;
import java.io.FileNotFoundException;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import Generic_Utility.Webdriver_Utility;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//Reference: https://dumbitdude.com/how-to-write-data-into-excel-sheet-using-selenium-webdriver/
/*Scenario: Launch Amazon-> search for iphone-> Navigated to the search results page-> 
* Get the model name and respective price and write into an excel sheet */
public class AmazonProducts{
	
	public static void main(String args[]) throws Throwable
	{		
	//Launching URL
	EdgeDriver driver = new EdgeDriver();	
	driver.get("https://www.amazon.in");
	Webdriver_Utility wlib = new Webdriver_Utility();
	wlib.maximizeWindow(driver);
	wlib.implicitWait(driver);
	
	//Searching for product
	WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
	searchBox.sendKeys("iphone");
	searchBox.submit();

	//creating Workbook and writing search results in it
	XSSFWorkbook wb = new XSSFWorkbook();
	XSSFSheet sh = wb.createSheet("iphone");

	int count=0, locatorCount;
	String iphoneModelLocator = "a-size-medium a-color-base a-text-normal";
	List<WebElement> iphoneList = driver.findElements(By.xpath("//span[@class='"+iphoneModelLocator+"']"));
for(WebElement iphoneModel:iphoneList)
		{
			String iphoneName = iphoneModel.getText();
			sh.createRow(count).createCell(0).setCellValue(iphoneName);
			
			locatorCount = count+1;
WebElement priceElement = driver.findElement(By.xpath("(//span[@class='"+iphoneModelLocator+"'])["+locatorCount+"]/ancestor::"
+ "div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
			String price = priceElement.getText();
			sh.getRow(count).createCell(8).setCellValue(price);
			count++;

		}

	//creating Excel sheet and copying the Workbook data to it 
	File file = new File("E:/Qspiders Adv Selenium/AmazonProducts.xlsx");
	FileOutputStream fos = new FileOutputStream(file);
	wb.write(fos);
	}
}
