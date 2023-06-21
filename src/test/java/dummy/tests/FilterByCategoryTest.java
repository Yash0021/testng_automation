package dummy.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dummy.base.BaseTest;
import dummy.pages.StorePage;

public class FilterByCategoryTest extends BaseTest {
	
	@Test
	public void testAddingItemBySelectingCategory() {
		StorePage storePage = new StorePage(getDriver())
				.load()
				.selectCategory();
		
		Assert.assertEquals(storePage.getActualNumberOfProducts(), storePage.getNumberOfProductDisplayed());
	}
}
