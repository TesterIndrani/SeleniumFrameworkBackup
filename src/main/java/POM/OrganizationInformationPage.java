package POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
// Scenario: In the Organization Information Page, validate if the Header contains name of the Organization created

public class OrganizationInformationPage {
	
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
  @FindBy(xpath="//span[@id='dtlview_Organization Name']")	//getting data from field instead of header 
	private WebElement actualOrganizationName;
	
  //getter method
	public WebElement getActualOrganizationName() {
		return actualOrganizationName;
	}
	
	//business logic
	public String organizationValidation(WebDriver driver,String orgName)
	{
	String actOrgName = actualOrganizationName.getText();
	
	if(actOrgName.contains(orgName))
	   {
	  	 System.out.println("validation pass for "+ orgName);
	   }
	   else
	   {
	  	 System.out.println("validation fail for "+ orgName);
	   }
		
	return actOrgName;		//returning actual Org name for validation through Hard Assert
	}
}
