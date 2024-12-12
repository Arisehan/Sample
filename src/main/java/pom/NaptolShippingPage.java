package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NaptolShippingPage {
	@FindBy(xpath="//select[@name='fktitle_id']")private WebElement title;
	@FindBy(xpath="//input[@name='firstName']")private WebElement firstName;
	@FindBy(xpath="//input[@name='lastName']")private WebElement lastName;
	@FindBy(xpath="//textarea[@name='address']")private WebElement completeAddress;
	@FindBy(xpath="//input[@name='landmark']")private WebElement landmark;
	@FindBy(xpath="//input[@name='pincode']")private WebElement pincode;
	@FindBy(xpath="//select[@name='state']")private WebElement selectState;
	@FindBy(xpath="//select[@name='city']")private WebElement selectCity;
	@FindBy(xpath="//input[@name='mobile']")private WebElement mobileNumber;
	@FindBy(xpath="//A[@id='addEditButton']")private WebElement saveAndProceed;
	
	public NaptolShippingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	  public void ClickOnTitle() {
		  title.click();
		  }

      public void SelectTitle(WebDriver driver, String value) {
			  Select select=new Select(title);
			  select.selectByContainsVisibleText(value);
		  }
     public void EnterFirstName(String name,WebDriver driver) {
    	 firstName.sendKeys(name);
    	 Actions action= new Actions(driver);
    	 action.sendKeys(Keys.TAB);
    	 action.perform();  	 
     }
     public void EnterLastName(String Lastname,WebDriver driver) {
    	 lastName.sendKeys(Lastname);
    	 Actions action= new Actions(driver);
    	 action.sendKeys(Keys.TAB);
    	 action.perform();  	 
     }
     
     public void EnterCompleteAddress(String address,WebDriver driver) {
    	 completeAddress.sendKeys(address);
    	 Actions action= new Actions(driver);
    	 action.sendKeys(Keys.TAB);
    	 action.perform(); 
     }
     public void EnterLandMark(String nearlandmark,WebDriver driver) {
    	 landmark.sendKeys(nearlandmark);
    	 Actions action= new Actions(driver);
    	 action.sendKeys(Keys.TAB);
    	 action.perform(); 
     }
     
     public void EnterPincode(String areapincode,WebDriver driver) {
    	 pincode.sendKeys(areapincode);
    	 Actions action= new Actions(driver);
    	 action.sendKeys(Keys.TAB);
    	 action.sendKeys(Keys.TAB);
    	 action.sendKeys(Keys.TAB);
    	 action.perform(); 
     }
     
    public void ClickOnSelecetState() {
		  selectState.click();
		  }
    
    public void SelectState(WebDriver driver, String state) {
			  Select select=new Select(selectState);
			  select.selectByContainsVisibleText(state);
			  Actions action= new Actions(driver);
		      action.sendKeys(Keys.TAB);
		      action.perform(); 
		  }   
    
    public void ClickOnSelectCity() {
		  selectCity.click();
		  }

     public void SelectCity(WebDriver driver, String city) {
			  Select select=new Select(selectCity);
			  select.selectByContainsVisibleText(city);
			  Actions action= new Actions(driver);
		      action.sendKeys(Keys.TAB);
		      action.perform();
		  }
     
    public void EnntreMobileNumber(String Number) {
    	mobileNumber.sendKeys(Number);
    }
    
    public void ClickOnSaveAndProceed() {
    	saveAndProceed.click();
    	
    }

}
