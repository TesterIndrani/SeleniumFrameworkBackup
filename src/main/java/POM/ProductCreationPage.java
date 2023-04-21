package POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*combining both Products Page and Creating New Product Page as Products Page has only single WebElement
 * Scenario:  Click on '+' sign-> Enter Product Name-> Click on [Save]	*/

public class ProductCreationPage {
	
	public ProductCreationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
    //Declaration
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement productCreateImage;
	
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	//getter Methods
	public WebElement getProductCreateImage() {
		return productCreateImage;
	}

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * This Method is used for ClickOn +img
	 */
	public void clickProductCreateImage()
	{
		productCreateImage.click();
	}

	/**
	 * This Method is used to Pass Value to Product TextField
	 */
	public void productNameTextField(String orgName)
	{
		productNameTextField.sendKeys(orgName);
	}
	
	/**
	 * This Method is used to Save OrgName
	 */
	public void clickSaveButton()
	{
		saveButton.click();	
	}


}
