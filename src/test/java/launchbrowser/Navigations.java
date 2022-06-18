package launchbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 WebDriverManager.chromedriver().setup();
			
			WebDriver driver=new ChromeDriver();
			driver.get("https://m.snapdeal.com/");
			driver.get("https://www.amazon.com/");
			
			driver.navigate().back();
			driver.navigate().forward();
			driver.navigate().refresh();
			driver.navigate().to("https://m.snapdeal.com/");
			
			

	}

}
