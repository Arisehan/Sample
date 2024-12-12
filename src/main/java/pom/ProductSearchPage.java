package pom;


import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ProductSearchPage {
	
	@FindBy (xpath="//div[@class='grid_Square ']")private List<WebElement> products;
	@FindBy (xpath="//div[@class='item_title']//a")private List<WebElement> productName;
	@FindBy (xpath=" //span[text()='Quick View']")private List<WebElement> quickView;
	@FindBy(xpath="//a[@class='red_button icon chat']")private WebElement clickHereTocart;
	@FindBy(xpath="//select[@id='sortByFilter']")private WebElement sortBy;
	
	public ProductSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	 public int getNumberOfDisplayedProducts(WebDriver driver) {
		 int size=products.size();
		return size;
	 }
	 
	  public void selectProduct(int index) {
		  products.get(index).click();
		
	  }
	  
	  public String getProductName(int index) {
		   return productName.get(index).getText();
	  }
	  
	  public void moveMouseToProduct(WebDriver driver, int index) {
		  Actions action= new Actions(driver);
		  action.moveToElement(products.get(index));
		  action.perform();
		  
	  }
	  
	  public void ClickonClickView(int index) {
		  quickView.get(index).click();
		}
	  
	  public void ClickOnSortBy() {
	  sortBy.click();
	  }

	  public void SelectSortOption(WebDriver driver, String value) {
		  Select select=new Select(sortBy);
		  select.selectByContainsVisibleText(value);
	  }
}
