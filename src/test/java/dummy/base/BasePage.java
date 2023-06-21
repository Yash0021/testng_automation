package dummy.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dummy.constants.CommonProps;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void loadUrl(String endPoint) {
		String url = CommonProps.baseUrl + endPoint;
		driver.get(url);
	}
	
	public WebElement waitForElementToLoad(By element) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public String getTextFromElement(By xpath) {
		return waitForElementToLoad(xpath).getText();
	}
}
