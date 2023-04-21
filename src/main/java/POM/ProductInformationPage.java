package POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
// Scenario: In the Product Information Page, validate if the Header contains name of the Product created

public class ProductInformationPage {
	
	public ProductInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
  @FindBy(xpath="//span[@id='dtlview_Product Name']")
	private WebElement actualProductName;
  
	
  //getter method
	public WebElement getActualProductName() {
		return actualProductName;
	}
	
	//business logic
	public String productValidation(WebDriver driver,String prodName)
	{
	String actProdName = actualProductName.getText();
	
	if(actProdName.contains(prodName))
	   {
	  	 System.out.println("validation pass for "+ prodName);
	   }
	   else
	   {
	  	 System.out.println("validation fail for "+ prodName);
	   }
	return actProdName;
	}
}
