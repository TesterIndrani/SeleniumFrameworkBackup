package POM;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*Scenario: Navigated to Products Information Page-> click on [Products]-> In Products page, select the
 * checkbox beside newly created product name-> Click on [Delete]-> click on [OK] in Alert Popup
 * -> validate if the product is deleted from the table*/

public class ProductDeletionValidation {

	//create constructor(initialization)
	public ProductDeletionValidation (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(xpath="(//a[.='Products'])[2]")
	private WebElement productsLinkText ;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteProduct;

	//getters
	public WebElement getProductsLinkText() {
		return productsLinkText;
	}

	public WebElement getDeleteProduct() {
		return deleteProduct;
	}

	//Business logic 
	public void clickProductsLinkText(WebDriver driver)
	{
		productsLinkText.click();
	}

	public void clickDeleteProduct()
	{
		deleteProduct.click();
	}
	
	public boolean prodDeletionValidation(WebDriver driver,String prod_name) {
	List<WebElement> Lists = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
/*Fetching the list of product names in the 2nd column of the table. 
 * Note: position()>1 is to exclude the first row of the table i.e. column name
 * Should declare List of WebElements in Business logic only as @FindBy cannot be used for finding multiple WebElements	*/
	
	        boolean flag=false;
	        for(WebElement wb:Lists)
	        {
	        	String act = wb.getText();
	        	if(act.contains(prod_name))
	        	{
	        		flag=true;
	        		break;
	        	}
	        }
	        if(flag)
	        {
	        	System.out.println(prod_name+" not deleted");
	        	
	        }
	        else
	        {
	        	System.out.println(prod_name+" deleted");
	        }
		
	    return flag;
		
	    }


	
   }
