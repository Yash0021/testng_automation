package dummy.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import dummy.constants.BrowserNames;
import dummy.driverManager.DriverManagerAbstract;
import dummy.driverManager.DriverManagerFactory;

public class BaseTest {
	private ThreadLocal<DriverManagerAbstract> driverManager = new ThreadLocal<DriverManagerAbstract>();
	private final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return this.driver.get();
	}
	
	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}
	
    private void setDriverManager(DriverManagerAbstract driverManager){
        this.driverManager.set(driverManager);
    }

    protected DriverManagerAbstract getDriverManager(){
        return this.driverManager.get();
    }
	
	@BeforeMethod
	@Parameters({"browser"})
	public void startDriver(@Optional("CHROME") String browser) {
		setDriverManager(DriverManagerFactory.getManager(BrowserNames.valueOf(browser)));
		setDriver(getDriverManager().getDriver());
	}
	
	@AfterMethod
	public void quitBrowser(@Optional String browser, ITestResult result) throws InterruptedException, IOException {
		try {
			Thread.sleep(500);
		} catch(Exception e) {
			System.out.println("Error quitting browser: " + e.getMessage());
		}
		
        getDriverManager().getDriver().quit();
		getDriver().quit();
	}
	
}
