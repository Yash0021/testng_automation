package dummy.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dummy.base.BaseTest;
import dummy.constants.CommonProps;
import dummy.pages.CheckoutPage;
import dummy.pages.StorePage;

public class StorePageTest extends BaseTest {
	@Test
	public void addItemToCartAndCheckoutTest() {
		StorePage storePage = new StorePage(getDriver())
				.load()
				.inputSearchTerm()
				.clickSearchButton();
		
		Assert.assertEquals(storePage.getStorePageTitle(), storePage.getExpectedPageTitle());

		CheckoutPage checkoutPage = storePage.addItemToCart(getDriver())
				.openCart()
				.goToCheckoutPage()
				.insertFirstName()
				.insertLastName()
				.insertStreetAddress()
				.insertCityName()
				.insertPostalCode()
				.insertEmailAddress()
				.clickPlaceOrderButton();
		
		Assert.assertEquals(checkoutPage.getSuccessOrderMessage(), CommonProps.successMessageCheckout);
	}
}
