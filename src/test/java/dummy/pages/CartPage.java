package dummy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dummy.base.BasePage;

public class CartPage extends BasePage {

	private By viewCartButton = By.xpath("//a[@class='added_to_cart wc-forward']");
	private By checkoutPageButton = By.xpath("//a[@class='checkout-button button alt wc-forward']");
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public CartPage openCart() {
		waitForElementToLoad(viewCartButton).click();
		return this;
	}
	
	public CheckoutPage goToCheckoutPage() {
		waitForElementToLoad(checkoutPageButton).click();
		return new CheckoutPage(driver);
	}
}
