package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.NaptolHomePage;
import pom.ProductSearchPage;

@Listeners(test.Listener.class)
public class VerifyProductDisplayedPostSearch extends BaseTest {
	@BeforeMethod
	@Parameters("Browser")
	public void openBrowser(String name) {
		driver=Browser.launchbrowser("name");
	}
	
	@Test
	public void verifyProductAreDisplayedForValidSearch() {
		NaptolHomePage naptolhomepage= new NaptolHomePage(driver);
		naptolhomepage.enterProductToSearchFeild("cooker");
		naptolhomepage.clickOnSearchButton();
		
		ProductSearchPage productsearchpage= new ProductSearchPage(driver);
		int products=productsearchpage.getNumberOfDisplayedProducts(driver);
		System.out.println(products);
		
		Assert.assertTrue(products>0);
	}
	
	@Test
	public void verifyProductNotDisplayedForInvalidSearch() {
		NaptolHomePage naptolhomepage= new NaptolHomePage(driver);
		naptolhomepage.enterProductToSearchFeild("macbook");
		naptolhomepage.clickOnSearchButton();
		
		ProductSearchPage productsearchpage= new ProductSearchPage(driver);
		int products=productsearchpage.getNumberOfDisplayedProducts(driver);
		System.out.println(products);
		
		Assert.assertEquals(products, 0);
	}

}
