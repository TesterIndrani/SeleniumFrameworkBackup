package POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Scenario: Login to vtiger application
public class LoginPage {
	
	//create constructor(initialization)
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		//PageFactory-->class 
		//initElements-->static method
	}
	
	//declaration
	@FindBy(name = "user_name")
	private WebElement usernameEdTxt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdTxt;
	
	@FindBy(id = "submitButton")
	private WebElement submitBtn;

	
	//utilization
	public WebElement getUsernameEdTxt() {
		return usernameEdTxt;
	}

	public WebElement getPasswordEdTxt() {
		return passwordEdTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//business logic
	/**
	 * login method
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username, String password)
	{
		usernameEdTxt.sendKeys(username);
		passwordEdTxt.sendKeys(password);
		submitBtn.click();
	}
	
}
