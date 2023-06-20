package EcommPageobject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StanaloneCopy {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDriver\\chromeDriver\\chromedriver_win32\\chromedriver.exe");  
		//		ChromeOptions co = new ChromeOptions();
		//	    co.addArguments(Arrays.asList("--remote-allow-origins=*",  "--lang=en_US"));
		String productName= "IPHONE 13 PRO";
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		LangingPage landingPage =new LangingPage(driver);
		landingPage.goTo();
		
		ProductCatalogue productCatalogue=landingPage.LoginpageAction("sharunm@gmail.com","Saran*123");
		//productCatalogue.getProductList();

		CartPage cartPage = productCatalogue.addProductToCart(productName);
		productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyCartProductDisplay(productName);


		Assert.assertTrue(match);
		cartPage.goToCheckoutPage(); 

		CheckoutPage checkoutPage = new CheckoutPage(driver);
		
		checkoutPage.selectCountryMethod("india");
		checkoutPage.placeOrderClick();
		 ThankYou thankyou=new ThankYou(driver)  ;
		  String confirmationMessage=thankyou.thankYouDisplayString();
		Assert.assertTrue(confirmationMessage .equalsIgnoreCase("Thankyou for the order."));



	}


}
