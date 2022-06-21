package launchbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WenTableHandling {

	public static void main(String[] args) {
		// 1. how many number if rows in table
		// 2. How many columns in table
		// 3. Retrieve the specific row/column data
		// 4. Retrieve all the data from the table
		// 5. print release date, versionNo of java application

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		
		// 1. how many number if rows in table
		

	}

}
