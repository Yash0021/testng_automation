package dummy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dummy.base.BasePage;
import dummy.constants.InputParameters;

public class CheckoutPage extends BasePage {
	private By firstNameInput = By.xpath("//input[@id='billing_first_name']");
	private By lastNameInput = By.xpath("//input[@id='billing_last_name']");
	private By streetAddressInput = By.xpath("//input[@id='billing_address_1']");
	private By cityInput = By.xpath("//input[@id='billing_city']");
	private By postalCodeInput = By.xpath("//input[@id='billing_postcode']");
	private By emailInput = By.xpath("//input[@id='billing_email']");
	private By placeOrderButton = By.id("place_order");
	private By successMessage = By.xpath("//div[@class='woocommerce-order']//following-sibling::p");
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public CheckoutPage insertFirstName() {
		waitForElementToLoad(firstNameInput).sendKeys(InputParameters.firstName);
		return this;
	}

	public CheckoutPage insertLastName() {
		driver.findElement(lastNameInput).sendKeys(InputParameters.lastName);
		return this;
	}

	public CheckoutPage insertStreetAddress() {
		driver.findElement(streetAddressInput).sendKeys(InputParameters.stateName);
		return this;
	}
	
	public CheckoutPage insertPostalCode() {
		driver.findElement(postalCodeInput).sendKeys(InputParameters.postalCode);
		return this;
	}
	
	public CheckoutPage insertCityName() {
		driver.findElement(cityInput).sendKeys(InputParameters.cityName);
		return this;
	}
	
	public CheckoutPage insertEmailAddress() {
		driver.findElement(emailInput).sendKeys(InputParameters.emailAddress);
		return this;
	}
	
	public CheckoutPage clickPlaceOrderButton() {
		driver.findElement(placeOrderButton).click();
		return this;
	}
	
	public String getSuccessOrderMessage() {
		return waitForElementToLoad(successMessage).getText();
	}

}
