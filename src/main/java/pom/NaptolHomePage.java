package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NaptolHomePage {
	@FindBy(xpath="//a[@id='login-panel-link']")private WebElement loginorRegister;
	@FindBy(xpath="//a[@id='registration-panel-link']")private WebElement trackOrder;
	@FindBy(xpath="//div[@class='cate_head']")private WebElement shoppingCategories;
	@FindBy(xpath="//input[@id='header_search_text']")private WebElement searchFeild;
	@FindBy(xpath="(//a[@href='javascript:autoSuggestion.headerSearch()'])[2]")private WebElement searchButton;
	@FindBy(xpath="(//a[@id='cart-panel-link'])[2]")private WebElement cart;
	@FindBy(xpath="//a[@href='/shop-online/home-kitchen-appliances.html']")private List<WebElement> shoppingCategoriesFilter;
	@FindBy(xpath="(//a[text()='Cookware'])[1]")private WebElement cookewear;
	@FindBy(xpath="//input[@id='iscod']")private WebElement withCashOnDeliveryCheckbox;
	@FindBy(xpath="//input[@id='isexoutStock']")private WebElement excludeOutOfStockCheckbox;
	@FindBy(xpath="//input[@id='isfreeship']")private WebElement productWithFreeShippingCheckbox;
	@FindBy(xpath="//input[@id='pincode']")private WebElement pinCode;
	@FindBy(xpath="//a[@onclick='productSearch.setPersonalisedFilter(false);']")private WebElement setButton;

	
	public NaptolHomePage(WebDriver driver) {  //constructor
		PageFactory.initElements(driver, this);
	}

	public void clickOnLoginRegister() {
		loginorRegister.click();
	}
	
	public void trackOrder() {
		trackOrder.click();
	}
	
	public void moveFocusOnShoppingCategories(WebDriver driver) {
	 Actions action= new Actions(driver);
	 action.moveToElement(shoppingCategories);
	 action.perform();
	}
	
	public void moveFocusOnShoppingCategoriesByFilter(WebDriver driver, int index) {
		 Actions action= new Actions(driver);
		 action.moveToElement(shoppingCategoriesFilter.get(index));
		 action.perform();
	}
	
	public void clickOnCookWear() {
		cookewear.click();
	}
	
	public void enterProductToSearchFeild(String product) {
		searchFeild.sendKeys(product);
	}
	 public void clickOnSearchButton() {
		 searchButton.click();
	 }
	 
	 public void goToCart() {
		 cart.click();
	 }
	 
	 public void clickOnCashOnDeliveryChechbox() {
		 withCashOnDeliveryCheckbox.click();
	 }
	 
	 public void clickOnExcludeOutOfStockChechbox() {
		 excludeOutOfStockCheckbox.click();
	 }
	 
	 public void clickOnProductWithFreeShippingChechbox() {
		 productWithFreeShippingCheckbox.click();
	 }
	 
	 public void EnterPincode(String pincode) {
		 pinCode.sendKeys(pincode);
	 }
	 
	 public void ClickonSetButton() {
		 setButton.click();
	 }
	
}
