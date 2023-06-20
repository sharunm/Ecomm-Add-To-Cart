package EcommPageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommResources.AbstractComponent;

public class CartPage  extends AbstractComponent {

	WebDriver driver;
 public CartPage(WebDriver driver)

	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(xpath="//div[@class='cartSection']/h3")
    private List<WebElement> cartSelection;
	
    @FindBy(css=".subtotal button")
    WebElement checkOut;
	
	public Boolean verifyCartProductDisplay(String productName) {
		
		Boolean match=  cartSelection.stream().anyMatch(cartselected-> cartselected.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public void goToCheckoutPage()
	{
		checkOut.click();
	}
	
}
