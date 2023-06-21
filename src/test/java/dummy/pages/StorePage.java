package dummy.pages;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import dummy.base.BasePage;
import dummy.constants.InputParameters;

public class StorePage extends BasePage {
	private String searchTerm = "blue";
//	private By storePageLink = By.xpath("('//a[text()='Store'])[1]");
	private By searchBox = By.id("woocommerce-product-search-field-0");
	private By searchButton = By.xpath("//button[text()='Search']");
	private By searchPageTitle = By.xpath("//h1");
	private By addToCartButton = By.xpath("//a[@href='?add-to-cart=1215']");
	private By categoryXpath = By.xpath("//select[@id='product_cat']");
	private By elementsPath = By.xpath("//span[@class='ast-woo-product-category']");
	private By getActualNumberOfProduct = By.xpath("//p[@class='woocommerce-result-count']");
	
	public StorePage(WebDriver driver) {
		super(driver);
	}
	
	public StorePage load() {
		loadUrl("/store/");
		return this;
	}
	
	public StorePage inputSearchTerm() {
		waitForElementToLoad(searchBox).sendKeys(searchTerm);
		return this;
	}
	
	public StorePage clickSearchButton() {
		driver.findElement(searchButton).click();
		return this;
	}
	
	public String getStorePageTitle() {
		return waitForElementToLoad(searchPageTitle).getText();
	}
	
	public String getExpectedPageTitle() {
		String title = "Search results: “" + searchTerm + "”";
		return title;
	}
	
	public CartPage addItemToCart(WebDriver driver) {
		waitForElementToLoad(addToCartButton).click();
		return new CartPage(driver);
	}
	
	public StorePage selectCategory() {
		Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(categoryXpath)));
		select.selectByValue(InputParameters.category);
		return this;
	}
	
	public int getNumberOfProductDisplayed() {
		List<WebElement> elements = driver.findElements(elementsPath);
		return elements.size();
	}
	
	public int getActualNumberOfProducts() {
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(getTextFromElement(getActualNumberOfProduct));
		if(matcher.find()) {
			return Integer.parseInt(matcher.group());
		} else {
			return -1;
		}
	}
}
