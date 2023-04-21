package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Generic_Utility.Webdriver_Utility;
//Scenario: Click on Organizations/Products/More->Campaigns/signOutImg->SignOut

public class HomePage {

	//create constructor(initialization)
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLinkText;
	
	@FindBy(linkText = "Products")
	private WebElement productsLinkText;
	
	@FindBy(linkText = "More")
	private WebElement moreLinkText;
	
	@FindBy(name = "Campaigns")
	private WebElement campaignsLinkText;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutImg;
			
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLinkText;

	
	//utilization
	public WebElement getOrganizationsLinkText() {
		return organizationsLinkText;
	}
	public WebElement getProductsLinkText() {
		return productsLinkText;
	}
	public WebElement getMoreLinkText() {
		return moreLinkText;
	}
	public WebElement getCampaignsLinkText() {
		return campaignsLinkText;
	}
	public WebElement getSignOutImg() {
		return signOutImg;
	}
	public WebElement getSignOutLinkText() {
		return signOutLinkText;
	}
	
	
	
	//Business logic for Organizations
	public void clickOrganizationsLinkText()
	{
		organizationsLinkText.click();
	}
	//Business logic for Products
	public void clickProductsLinkText()
	{
		productsLinkText.click();
	}
	//Business logic for More
	public void clickMoreLinkText(WebDriver driver)
	{
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.mouseOverOnElement(driver, moreLinkText);
	}
	//Business logic for Campaigns
	public void clickCampainsLinkText()
	{
		campaignsLinkText.click();
	}
	//Signout
	public void clickSignOutLinkText(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(signOutImg).perform();
		signOutLinkText.click();
	}
}

