package pojo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	static WebDriver driver;
	public static WebDriver launchbrowser(String name) {
		if(name.equals("Chrome")) 
		{
		WebDriverManager.chromedriver().setup();// browser setup
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
	    driver=new ChromeDriver(opt);//casting
		}
		else if(name.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			 driver= new EdgeDriver();
		}
		else if(name.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver= new FirefoxDriver();
		}
	
		driver.get("https://www.naaptol.com");
		driver.manage().window().maximize();
		return driver;
		
	}

}
