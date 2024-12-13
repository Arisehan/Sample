package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaptolProductSpecificationPage {
	@FindBy(xpath="//a[@id='cart-panel-button-0']")private WebElement clickHereToBuyButton;
	@FindBy(xpath="//input[@id='pincodeDeliveryId_0']")private WebElement EntrePincode;
	@FindBy(xpath="//span[text()=' Check ']")private WebElement checkButton;
	
	public NaptolProductSpecificationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ClickonClickHereToBuyButton() {
		clickHereToBuyButton.click();
	}
	
	public void EntrePincode(String pincode){
		EntrePincode.sendKeys("pincode");
	}
	
	public void ClickOnChcekButton() {
		checkButton.click();
	}
}
