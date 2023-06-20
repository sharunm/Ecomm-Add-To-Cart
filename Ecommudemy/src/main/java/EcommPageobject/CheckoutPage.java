package EcommPageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import EcommResources.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;
	public CheckoutPage(WebDriver driver)

	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".action__submit")
	WebElement submitbutton;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement placeOrder;
	
	By results=By.cssSelector(".ta-results");
	public void selectCountryMethod(String countryName)
	{
	Actions a = new Actions(driver);
	a.sendKeys(selectCountry, countryName).build().perform();
	waitForElementtoAppear(results);
	placeOrder.click();
	
	}
	public void placeOrderClick()
	{
		submitbutton.click();	
	}
}
