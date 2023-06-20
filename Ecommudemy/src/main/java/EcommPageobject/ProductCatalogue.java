package EcommPageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommResources.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)

	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	By productsBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:nth-of-type(2)");
	By toastMessage=By.cssSelector("#toast-container");
	By spinner= By.cssSelector(".ng-animating");
	public List<WebElement> getProductList()
	{
		waitForElementtoAppear(productsBy);
		return products;
	}

	public WebElement getProductName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
	}
	public CartPage addProductToCart(String productName)
	{
		WebElement prod = getProductName(productName);

		prod.findElement(addToCart).click();
		waitForElementtoAppear(toastMessage);
		waitForElementToDisappear(spinner);
		return new CartPage(driver);
	}


}

