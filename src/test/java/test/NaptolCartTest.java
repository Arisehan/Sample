package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaptolCartPage;
import pom.NaptolHomePage;
import pom.NaptolProductSpecificationPage;
import pom.NaptolShippingPage;
import pom.ProductSearchPage;

@Listeners(test.Listener.class)
public class NaptolCartTest extends BaseTest {
	
	@BeforeMethod
	//@Parameters("Browser")
	public void launchBrowser() {
		driver=Browser.launchbrowser("Chrome");
	}
	
	@Test(priority=1)
	public void searchSingleProductAndAddToCartAndProceedToCheckOut() throws InterruptedException {
		NaptolHomePage naptolhomepage= new NaptolHomePage(driver);
		naptolhomepage.enterProductToSearchFeild("cooker");
		naptolhomepage.clickOnSearchButton();
		
		ProductSearchPage productsearchpage= new ProductSearchPage(driver);
		productsearchpage.selectProduct(0);
	    switchToChildWindow(productsearchpage.getProductName(0));
		
		NaptolProductSpecificationPage naptolproductspecificationpage= new NaptolProductSpecificationPage(driver);
		naptolproductspecificationpage.EntrePincode("413002");
		naptolproductspecificationpage.ClickOnChcekButton();
		naptolproductspecificationpage.ClickonClickHereToBuyButton();
		
		NaptolCartPage naptolcartpage= new NaptolCartPage(driver);
		naptolcartpage.waitForCartToDisplay(driver);
		Assert.assertEquals(naptolcartpage.getCartItem(), 1);
		
		naptolcartpage.ClickOnProceedToCheckOut();
		Thread.sleep(50000);
		
		NaptolShippingPage naptolshippingpage=new NaptolShippingPage(driver);
		naptolshippingpage.ClickOnTitle();
		naptolshippingpage.SelectTitle(driver, "Mrs.");
		naptolshippingpage.EnterFirstName("Aparna", driver);
		naptolshippingpage.EnterLastName("Bhave",driver);
		naptolshippingpage.EnterCompleteAddress("Solapur",driver);
		naptolshippingpage.EnterLandMark("SaatRasta",driver);
		naptolshippingpage.EnterPincode("413002",driver);
		
//		naptolshippingpage.ClickOnSelecetState();
//		naptolshippingpage.SelectState(driver, "Maharashtra");
//		naptolshippingpage.ClickOnSelectCity();
//		naptolshippingpage.SelectCity(driver, "Solapur");
//		naptolshippingpage.EnntreMobileNumber("7798800873");
		naptolshippingpage.ClickOnSaveAndProceed();
	}
	
	@Test(priority=2)
	public void searchSingleProductAndAddToCartByUsingQuickView() {
		NaptolHomePage naptolhomepage= new NaptolHomePage(driver);
		naptolhomepage.enterProductToSearchFeild("cooker");
		naptolhomepage.clickOnSearchButton();
		
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
	public void searchSingleProductAndAddToCartAndRemoveFromCart() {
		NaptolHomePage naptolhomepage= new NaptolHomePage(driver);
		naptolhomepage.enterProductToSearchFeild("cooker");
		naptolhomepage.clickOnSearchButton();
		
		ProductSearchPage productsearchpage= new ProductSearchPage(driver);
		productsearchpage.selectProduct(0);
	    switchToChildWindow(productsearchpage.getProductName(0));
		
		NaptolProductSpecificationPage naptolproductspecificationpage= new NaptolProductSpecificationPage(driver);
		naptolproductspecificationpage.EntrePincode("413002");
		naptolproductspecificationpage.ClickOnChcekButton();
		naptolproductspecificationpage.ClickonClickHereToBuyButton();
		
		NaptolCartPage naptolcartpage= new NaptolCartPage(driver);
		naptolcartpage.waitForCartToDisplay(driver);
		naptolcartpage.clickOnRemoveButton(0);
		naptolcartpage.waitForCartNoItemsToDispaled(driver);
		Assert.assertEquals(naptolcartpage.getCartItem(), 0);
		//Assert.assertEquals(naptolcartpage.GetMessage(), "You have No Items in Cart !!! ");
		
	}
	
	@Test(priority=4)
	public void addMultipleProductToCart() {
		NaptolHomePage naptolhomepage= new NaptolHomePage(driver);
		naptolhomepage.enterProductToSearchFeild("cooker");
		naptolhomepage.clickOnSearchButton();
		
		ProductSearchPage productsearchpage= new ProductSearchPage(driver);
		productsearchpage.selectProduct(0);
	    switchToChildWindow(productsearchpage.getProductName(0));
		
		NaptolProductSpecificationPage naptolproductspecificationpage= new NaptolProductSpecificationPage(driver);
		naptolproductspecificationpage.EntrePincode("413002");
		naptolproductspecificationpage.ClickOnChcekButton();
		naptolproductspecificationpage.ClickonClickHereToBuyButton();
		
		NaptolCartPage naptolcartpage= new NaptolCartPage(driver);
		naptolcartpage.waitForCartToDisplay(driver);
		naptolcartpage.clickOnContinueShoppping();
		
		naptolhomepage.enterProductToSearchFeild("cooker");
		naptolhomepage.clickOnSearchButton();
		
		productsearchpage.selectProduct(1);
	    switchToChildWindow(productsearchpage.getProductName(1));
	    
	    naptolproductspecificationpage.EntrePincode("413002");
		naptolproductspecificationpage.ClickOnChcekButton();
		
		naptolproductspecificationpage.ClickonClickHereToBuyButton();
    
	}

	@Test(priority=5)
	public void addMultipleProductToCartAndRemoveToCart(){
		NaptolHomePage naptolhomepage= new NaptolHomePage(driver);
		naptolhomepage.enterProductToSearchFeild("cooker");
		naptolhomepage.clickOnSearchButton();
		
		ProductSearchPage productsearchpage= new ProductSearchPage(driver);
		productsearchpage.selectProduct(0);
	    switchToChildWindow(productsearchpage.getProductName(0));
		
		NaptolProductSpecificationPage naptolproductspecificationpage= new NaptolProductSpecificationPage(driver);
		naptolproductspecificationpage.EntrePincode("413002");
		naptolproductspecificationpage.ClickOnChcekButton();
		naptolproductspecificationpage.ClickonClickHereToBuyButton();
		
		NaptolCartPage naptolcartpage= new NaptolCartPage(driver);
		naptolcartpage.waitForCartToDisplay(driver);
		naptolcartpage.clickOnContinueShoppping();
		
		naptolhomepage.enterProductToSearchFeild("cooker");
		naptolhomepage.clickOnSearchButton();
		
		productsearchpage.selectProduct(1);
	    switchToChildWindow(productsearchpage.getProductName(1));
		
		naptolproductspecificationpage.EntrePincode("413002");
		naptolproductspecificationpage.ClickOnChcekButton();
		
		naptolproductspecificationpage.ClickonClickHereToBuyButton();
		
    	naptolcartpage.waitForCartToDisplay(driver);
		naptolcartpage.clickOnRemoveButton(0);	
		
		naptolcartpage.waitForCartToDisplay(driver);
		naptolcartpage.clickOnRemoveButton(0);
		
		naptolcartpage.waitForCartNoItemsToDispaled(driver);
        Assert.assertEquals(naptolcartpage.getCartItem(), 0);
			
	}
}
