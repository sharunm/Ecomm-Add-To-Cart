package EcommPageobject;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import EcommResources.AbstractComponent;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LangingPage extends AbstractComponent{


	WebDriver driver;
	public LangingPage(WebDriver driver)

	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="userEmail")
	WebElement UserEmail;
	@FindBy(id="userPassword")
	WebElement Userpassword;
	@FindBy(id="login")
	WebElement loginbutton;

	public void goTo()
	{
		driver.get("http://www.rahulshettyacademy.com/client");	

	}


	public ProductCatalogue LoginpageAction(String mail,String pwd)
	{
		UserEmail.sendKeys(mail);
		Userpassword.sendKeys(pwd);
		loginbutton.click();
		return new ProductCatalogue(driver);
	}
}