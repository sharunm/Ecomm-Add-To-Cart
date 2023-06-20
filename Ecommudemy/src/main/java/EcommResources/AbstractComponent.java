package EcommResources;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;
public AbstractComponent(WebDriver driver)
	
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

    @FindBy(xpath="//button[contains(@routerlink,'/dashboard/cart')]")
    WebElement goToCart;

public void goToCartPage()
{
	
	
goToCart.click();
}


	public void waitForElementtoAppear(By findBy)
	{
		 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForElementToDisappear(By findBy1) 
	{
		//Thread.sleep(1000);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy1));
	}
	
	}
	

