package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NaptolCartPage {
	
	@FindBy(xpath="//ul[@id='cartData']")private List<WebElement> cartItem;
	@FindBy(xpath="(//button[@title='Close'])[2]")private WebElement close;
	@FindBy(xpath="//span[text()='You have No Items in Cart !!! ']") private WebElement youHaveNoItemInCart;
	@FindBy(xpath="//a[text()='Remove']")private List<WebElement> removeButton;
	@FindBy(xpath="(//a[@class='link_Continue'])[1]")private WebElement continueShopping;
	@FindBy(xpath="(//a[@class='red_button2'])[1]")private WebElement proceedToCheckOut;
	
	public NaptolCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void waitForCartToDisplay(WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(close));
	}
	             
	public void waitForCartNoItemsToDispaled(WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(youHaveNoItemInCart));
	}
	public int getCartItem(){
		int size=cartItem.size();
		return size;
	}
	
	public void clickOnRemoveButton(int index) {
		removeButton.get(index).click();
	}
	
	public void clickOnContinueShoppping() {
		continueShopping.click();
	}
	
	public String GetMessage() {
		return youHaveNoItemInCart.getText();
	}
	
	public void ClickOnProceedToCheckOut() {
		proceedToCheckOut.click();
	}
	

}
