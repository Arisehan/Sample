package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaptolCartPage;
import pom.NaptolHomePage;
import pom.NaptolProductSpecificationPage;
import pom.ProductSearchPage;

public class NaptolSortByAddedProductToCart extends BaseTest{
	
	@BeforeMethod
	//@Parameters("Browser")
	public void launchBrowser() {
		driver=Browser.launchbrowser("Chrome");
	}
	
	@Test(priority=1)
	public void searchSingleProductSortByAndAddToCart() {
		NaptolHomePage naptolhomepage=new NaptolHomePage(driver);
		naptolhomepage.enterProductToSearchFeild("cooker");
		naptolhomepage.clickOnSearchButton();
		
		ProductSearchPage productsearchpage= new ProductSearchPage(driver);
		productsearchpage.ClickOnSortBy();
		productsearchpage.SelectSortOption(driver, "New Arrivals");
		productsearchpage.selectProduct(0);
	    switchToChildWindow(productsearchpage.getProductName(0));
		
	    NaptolProductSpecificationPage naptolproductspecificationpage= new NaptolProductSpecificationPage(driver);
		naptolproductspecificationpage.ClickonClickHereToBuyButton();
		
		NaptolCartPage naptolcartpage= new NaptolCartPage(driver);
		naptolcartpage.waitForCartToDisplay(driver);
		Assert.assertEquals(naptolcartpage.getCartItem(), 1);
		
		
		
	}

}
