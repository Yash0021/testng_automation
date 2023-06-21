package dummy.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dummy.base.BaseTest;
import dummy.constants.CommonProps;
import dummy.constants.InputParameters;
import dummy.pages.LoginRegisterPage;

public class LoginRegisterPageTest extends BaseTest {
	@Test
	public void successfulLoginTest() {
		LoginRegisterPage loginPage = new LoginRegisterPage(getDriver())
				.load()
				.goToAccountPage()
				.inputUsername()
				.inputPassword()
				.clickLoginButton();
		
		Assert.assertEquals(loginPage.getSuccessfulLoginUsername(), CommonProps.username);
	}
	
	@Test
	public void loginWithoutUsername() {
		LoginRegisterPage loginPage = new LoginRegisterPage(getDriver())
				.load()
				.goToAccountPage()
				.inputPassword()
				.clickLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessage(), "Error:");
	}
	
	@Test
	public void loginWithoutPassword() {
		LoginRegisterPage loginPage = new LoginRegisterPage(getDriver())
				.load()
				.goToAccountPage()
				.inputUsername()
				.clickLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessage(), "Error");
	}
	
	@Test
	public void registerNewUserWithValidCreds() {
		LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver())
				.load()
				.goToAccountPage()
				.inserRegisterUsername()
				.inserRegisterEmail()
				.inserRegisterPassword()
				.clickRegisterButton();
		
		
		Assert.assertEquals(loginRegisterPage.getSuccessfulLoginUsername(), InputParameters.randomString);
	}
	
	@Test
	public void registerWithoutProvidingUsername() {
		LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver())
				.load()
				.goToAccountPage()
				.inserRegisterEmail()
				.inserRegisterPassword()
				.clickRegisterButton();
		
		
		Assert.assertEquals(loginRegisterPage.getErrorMessage(), "Error:");
	}
}
