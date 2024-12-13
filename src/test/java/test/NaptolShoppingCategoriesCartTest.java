package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaptolCartPage;
import pom.NaptolHomePage;
import pom.NaptolProductSpecificationPage;
import pom.ProductSearchPage;


@Listeners(test.Listener.class)
public class NaptolShoppingCategoriesCartTest extends BaseTest{
	@BeforeMethod
	//@Parameters("Browser")
	public void launchBrowser() {
		driver=Browser.launchbrowser("Chrome");
	}
	
	@Test(priority=1)
	public void searchSingleProductByShppingCategoriesAndAddToCart() {
		NaptolHomePage naptolhomepage= new NaptolHomePage(driver);
		naptolhomepage.moveFocusOnShoppingCategories(driver);
		naptolhomepage.moveFocusOnShoppingCategoriesByFilter(driver, 0);
		naptolhomepage.clickOnCookWear();
		
		ProductSearchPage productsearchpage= new ProductSearchPage(driver);
		productsearchpage.selectProduct(0);
	    switchToChildWindow(productsearchpage.getProductName(0));
			
		NaptolProductSpecificationPage naptolproductspecificationpage= new NaptolProductSpecificationPage(driver);
		naptolproductspecificationpage.ClickonClickHereToBuyButton();
			
		NaptolCartPage naptolcartpage= new NaptolCartPage(driver);
		naptolcartpage.waitForCartToDisplay(driver);
		Assert.assertEquals(naptolcartpage.getCartItem(), 1);	
	  }
	
	@Test(priority=2)
	public void searchSingleProductByShoppingCategoriesAndAddToCartByUsingQuickView() {
		NaptolHomePage naptolhomepage= new NaptolHomePage(driver);
		naptolhomepage.moveFocusOnShoppingCategories(driver);
		naptolhomepage.moveFocusOnShoppingCategoriesByFilter(driver, 0);
		naptolhomepage.clickOnCookWear();
		
		ProductSearchPage productsearchpage= new ProductSearchPage(driver);
		productsearchpage.moveMouseToProduct(driver, 0);
		productsearchpage.ClickonClickView(0);
		
		NaptolProductSpecificationPage naptolproductspecificationpage= new NaptolProductSpecificationPage(driver);
		naptolproductspecificationpage.ClickonClickHereToBuyButton();
		
		NaptolCartPage naptolcartpage= new NaptolCartPage(driver);
		naptolcartpage.waitForCartToDisplay(driver);
		Assert.assertEquals(naptolcartpage.getCartItem(), 1);
		
	}
	

	@Test(priority=3)
	public void searchSingleProductByShoppingCategoriesAndAddToCartAndRemoveFromCart() {
		NaptolHomePage naptolhomepage= new NaptolHomePage(driver);
		naptolhomepage.moveFocusOnShoppingCategories(driver);
		naptolhomepage.moveFocusOnShoppingCategoriesByFilter(driver, 0);
		naptolhomepage.clickOnCookWear();
		
		ProductSearchPage productsearchpage= new ProductSearchPage(driver);
		productsearchpage.selectProduct(0);
	    switchToChildWindow(productsearchpage.getProductName(0));
			
		NaptolProductSpecificationPage naptolproductspecificationpage= new NaptolProductSpecificationPage(driver);
		naptolproductspecificationpage.ClickonClickHereToBuyButton();
			
		NaptolCartPage naptolcartpage= new NaptolCartPage(driver);
		naptolcartpage.waitForCartToDisplay(driver);
		naptolcartpage.clickOnRemoveButton(0);
		naptolcartpage.waitForCartNoItemsToDispaled(driver);
		Assert.assertEquals(naptolcartpage.getCartItem(), 0);
	}
	
	@Test(priority=4)
	public void addMultipleProductToCartByShoppingCategories() {
		
		NaptolHomePage naptolhomepage= new NaptolHomePage(driver);
		naptolhomepage.moveFocusOnShoppingCategories(driver);
		naptolhomepage.moveFocusOnShoppingCategoriesByFilter(driver, 0);
		naptolhomepage.clickOnCookWear();
		
		ProductSearchPage productsearchpage= new ProductSearchPage(driver);
		productsearchpage.selectProduct(0);
	    switchToChildWindow(productsearchpage.getProductName(0));
			
		NaptolProductSpecificationPage naptolproductspecificationpage= new NaptolProductSpecificationPage(driver);
		naptolproductspecificationpage.ClickonClickHereToBuyButton();
		
		NaptolCartPage naptolcartpage= new NaptolCartPage(driver);
		naptolcartpage.waitForCartToDisplay(driver);
		naptolcartpage.clickOnContinueShoppping();
		
		naptolhomepage.enterProductToSearchFeild("cooker");
		naptolhomepage.clickOnSearchButton();
		
		productsearchpage.selectProduct(1);
	    switchToChildWindow(productsearchpage.getProductName(1));
		
		naptolproductspecificationpage.ClickonClickHereToBuyButton();
    
	}
	
	@Test(priority=5)
	public void addMultipleProductToCartAndRemoveToCart(){
		NaptolHomePage naptolhomepage= new NaptolHomePage(driver);
		naptolhomepage.moveFocusOnShoppingCategories(driver);
		naptolhomepage.moveFocusOnShoppingCategoriesByFilter(driver, 0);
		naptolhomepage.clickOnCookWear();
		
		ProductSearchPage productsearchpage= new ProductSearchPage(driver);
		productsearchpage.selectProduct(0);
	    switchToChildWindow(productsearchpage.getProductName(0));
			
		NaptolProductSpecificationPage naptolproductspecificationpage= new NaptolProductSpecificationPage(driver);
		naptolproductspecificationpage.ClickonClickHereToBuyButton();
		
		NaptolCartPage naptolcartpage= new NaptolCartPage(driver);
		naptolcartpage.waitForCartToDisplay(driver);
		naptolcartpage.clickOnContinueShoppping();
		
		naptolhomepage.enterProductToSearchFeild("cooker");
		naptolhomepage.clickOnSearchButton();
		
		productsearchpage.selectProduct(1);
	    switchToChildWindow(productsearchpage.getProductName(1));
		
		naptolproductspecificationpage.ClickonClickHereToBuyButton();
		
		naptolcartpage.waitForCartToDisplay(driver);
		naptolcartpage.clickOnRemoveButton(0);	
		
		naptolcartpage.waitForCartToDisplay(driver);
		naptolcartpage.clickOnRemoveButton(1);
		
		naptolcartpage.waitForCartNoItemsToDispaled(driver);
       Assert.assertEquals(naptolcartpage.getCartItem(), 0);
	}
	
}


