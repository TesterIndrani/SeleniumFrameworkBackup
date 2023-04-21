package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*Scenario: Click on '+' sign-> Enter Campaign Name-> Click on '+' sign beside 'Product' textfield-> 
 * After adding product, click on [Save] */
 
public class CampaignCreationPage {

	public CampaignCreationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	 
    //Declaration
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement campaignCreateImage;
	
	@FindBy(name="campaignname")
	private WebElement campaignNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement addProductSign;
	
	
	//getter Methods
	public WebElement getCampaignCreateImage() {
		return campaignCreateImage;
	}

	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getAddProductSign() {
		return addProductSign;
	}
	
	
	/**
	 * This Method is used for ClickOn +img
	 */
	public void clickCampaignCreateImage()
	{
		campaignCreateImage.click();
	}

	/**
	 * This Method is used to Pass Value to Campaign TextField
	 */
	public void campaignNameTextField(String campName)
	{
		campaignNameTextField.sendKeys(campName);
	}
	
	/**
	 * This Method is used to Save OrgName
	 */
	public void clickSaveButton()
	{
		saveButton.click();	
	}
	
	/**
	 * This method is used to click on '+' sign beside product textfield
	 */
	public void clickAddProductSign()
	{
		addProductSign.click();
	}
	
}
