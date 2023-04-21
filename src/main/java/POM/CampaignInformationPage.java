package POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/* Scenario: In the Campaign Information Page, validate if the Header contains name of the Campaign created
and information contains the product name passed while creating campaign */

public class CampaignInformationPage {
	public CampaignInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
    @FindBy(xpath="//span[@id='dtlview_Campaign Name']")
	private WebElement actualCampaignName;
/*Note we need to get Header element using any attribute except text() function. 
	  * Because, we want to validate it without using excel data */
	
    @FindBy(xpath="//span[@id='dtlview_Product']")
    private WebElement actualProductName;
    
    
    //getter method
	public WebElement getActualCampaignName() {
		return actualCampaignName;
	}
	
	public WebElement getActualProductName() {
		return actualProductName;
	}
	
	
	//business logics
	public String campaignValidation(WebDriver driver,String campName)
	{
	String actCampName = actualCampaignName.getText();
	
	if(actCampName.contains(campName))
	   {
	  	 System.out.println("validation pass for "+ campName);
	   }
	   else
	   {
	  	 System.out.println("validation fail for "+ campName);
	   }
	return actCampName;
	}
	
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
