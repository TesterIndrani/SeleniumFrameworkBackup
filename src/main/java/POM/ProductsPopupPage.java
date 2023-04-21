package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*Scenario:  click on 'Search' textfield and pass Product name created just now-> Click on [Search Now]->
 *  In the search result, click on the product name */

public class ProductsPopupPage {
	
	//initialization
	public ProductsPopupPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
    //Declaration
	@FindBy(id="search_txt")
	private WebElement searchTextField;
	
	@FindBy(name="search")
	private WebElement searchNowButton;

	
	//getter methods
	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}
	
	
	//Business Logic
	public void searchTextField(String prodName)
	{
		searchTextField.sendKeys(prodName);
	}
	
	public void clickSearchNowButton()
	{
		searchNowButton.click();
	}
}
