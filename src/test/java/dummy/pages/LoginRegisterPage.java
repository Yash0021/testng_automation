package dummy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dummy.base.BasePage;
import dummy.constants.CommonProps;
import dummy.constants.InputParameters;

public class LoginRegisterPage extends BasePage {
	private By accountPageLink = By.xpath("(//a[text()='Account'])[1]");
	private By usernameInput = By.id("username");
	private By passwordInput = By.id("password");
	private By loginButton = By.xpath("//button[@name='login']");
	private By displayedUsername = By.xpath("//p//strong[1]");
	private By displayedError = By.xpath("//li//following-sibling::strong");
	
	private By registerUsername = By.id("reg_username");
	private By registerEmailAddress = By.id("reg_email");
	private By registerPassword = By.id("reg_password");
	private By registerButton = By.xpath("//button[@name='register']");

	private static final String randomUsername = InputParameters.randomString;
	
	public LoginRegisterPage(WebDriver driver) {
		super(driver);
	}
	
	public LoginRegisterPage load() {
		loadUrl("/");
		return this;
	}
	
	public LoginRegisterPage goToAccountPage() {
		waitForElementToLoad(accountPageLink).click();
		return this;
	}
	
	public LoginRegisterPage inputUsername() {
		waitForElementToLoad(usernameInput).sendKeys(CommonProps.username);
		return this;
	}
	
	public LoginRegisterPage inputPassword() {
		driver.findElement(passwordInput).sendKeys(CommonProps.password);
		return this;
	}
	
	public LoginRegisterPage clickLoginButton() {
		driver.findElement(loginButton).click();
		return this;
	}
	
	public String getSuccessfulLoginUsername() {
		return waitForElementToLoad(displayedUsername).getText();
	}
	
	public String getErrorMessage() {
		return waitForElementToLoad(displayedError).getText();
	}
	
	public LoginRegisterPage inserRegisterUsername() {
		waitForElementToLoad(registerUsername).sendKeys(randomUsername);
		return this;
	}

	public LoginRegisterPage inserRegisterEmail() {
		driver.findElement(registerEmailAddress).sendKeys(randomUsername + "@dummy.com");
		return this;
	}
	
	public LoginRegisterPage inserRegisterPassword() {
		driver.findElement(registerPassword).sendKeys(InputParameters.registerPassword);
		return this;
	}
	
	public LoginRegisterPage clickRegisterButton() {
		driver.findElement(registerButton).click();
		return this;
	}
	
}
