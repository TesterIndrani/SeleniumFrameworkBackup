package POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*combining both Organizations Page and Creating New Organization Page as Organizations Page has only single WebElement
 * Scenario:  Click on '+' sign-> Enter Organization Name-> Click on [Save]	*/

public class OrganizationCreationPage {
	
	public OrganizationCreationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
    //Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement organizationCreateImage;
	
	@FindBy(name="accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	//getter Methods
	public WebElement getOrganizationCreateImage() {
		return organizationCreateImage;
	}
	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
		

	/**
	 * This Method is used for ClickOn +img
	 */
	public void clickOrganizationCreateImage()
	{
		organizationCreateImage.click();
	}

	/**
	 * This Method is used to Pass Value to Organization TextField
	 */
	public void organizationNameTextField(String orgName)
	{
		organizationNameTextField.sendKeys(orgName);
	}
	
	/**
	 * This Method is used to Save OrgName
	 */
	public void clickSaveButton()
	{
		saveButton.click();	
	}
}
