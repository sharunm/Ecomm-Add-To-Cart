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

public class StandaloneAddCart {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDriver\\chromeDriver\\chromedriver_win32\\chromedriver.exe");  
//		ChromeOptions co = new ChromeOptions();
//	    co.addArguments(Arrays.asList("--remote-allow-origins=*",  "--lang=en_US"));
		WebDriverManager.chromedriver().setup();

	    WebDriver driver=new ChromeDriver(); 
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("http://www.rahulshettyacademy.com/client");
	    driver.findElement(By.id("userEmail")).sendKeys("sharunm@gmail.com") ;
	    driver.findElement(By.id("userPassword")).sendKeys("Saran*123") ;
	    driver.findElement(By.id("login")).click();
	    List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	    WebElement prod = products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
	   
	    prod.findElement(By.cssSelector(".card-body button:nth-of-type(2)")).click();
	   // toast-container
	    WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
	    driver.findElement(By.xpath("//button[contains(@routerlink,'/dashboard/cart')]")).click();
	    List<WebElement> cartSelection=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
	  Boolean match=  cartSelection.stream().anyMatch(cartselected-> cartselected.getText().equalsIgnoreCase("IPHONE 13 PRO"));
	   Assert.assertTrue(match);
	   driver.findElement(By.cssSelector(".subtotal button")).click();
	   Actions a = new Actions(driver);
	   a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	   WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(10));
	   wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	   driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	   driver.findElement(By.cssSelector(".action__submit")).click();
	  String Thankyou = driver.findElement(By.cssSelector(".hero-primary")).getText();
	  Assert.assertTrue(Thankyou .equalsIgnoreCase("Thankyou for the order."));
	   
	    
	    
}

}
