package EcommPageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommResources.AbstractComponent;

public class ThankYou extends AbstractComponent{
	WebDriver driver;
	public ThankYou(WebDriver driver)

	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement thankYou;
	
	
	public String thankYouDisplayString()
	{
		return thankYou.getText();

	}
}
