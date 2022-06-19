package launchbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {
		//edge browser
//		System.setProperty("webdriver.edge.driver","C:\\Users\\enlem\\Downloads\\msedgedriver.exe");
//		WebDriver driver=new EdgeDriver();
		// firefox     webdriver.gekco.driver
		
		//2. or we can user webdrivermanager
	//	WebDriverManager.chromedriver().setup();
	//	WebDriver driver=new ChromeDriver();
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
	//	WebDriverManager.firefoxdriver().setup();
	//	WebDriver driver=new FirefoxDriver();
		driver.get("https://frontend.nopcommerce.com");
		
		System.out.println("Title of the page is "+driver.getTitle());
		System.out.println("URL of the webpage is "+driver.getCurrentUrl());
		System.out.println(driver.getPageSource());

	}

}
