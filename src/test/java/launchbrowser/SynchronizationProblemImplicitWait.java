package launchbrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SynchronizationProblemImplicitWait {

	public static void main(String[] args) {
		// no balance between automation script and application response.
		// wait statement can be used for this problem
		// Thread.sleep(ms) this is java feature
		// 1. Implicit wait this is a global wait. applicable for all elements
		// in the page
		// 2. Explicit wait
		// 3. Fluent Wait

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		// add implicit wait, Can only be used once. this is static wait(if
		// takes more than 10 sec, exception will hapeen)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);// click on Enter
																// Key
		driver.findElement(By.xpath("//h3[text()='Selenium']")).click();
		driver.quit();

	}

}
