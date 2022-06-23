package launchbrowser;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenURLsInTwoTabs {

	public static void main(String[] args) {
		// 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.nopcommerce.com/");
		
		// Different Tab
	//	driver.switchTo().newWindow(WindowType.TAB);
		//Different Window
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();

	}

}
