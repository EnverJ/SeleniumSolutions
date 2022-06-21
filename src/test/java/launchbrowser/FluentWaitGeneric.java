package launchbrowser;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitGeneric {

	public static void main(String[] args) {
		// 
		// fluent wait similar to WebDriverWait with more flexibility in polling time and ignore exception
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();	
				driver.get("https://www.google.com/");
				driver.manage().window().maximize();	
				driver.findElement(By.name("q")).sendKeys("Selenium");
				driver.findElement(By.name("q")).sendKeys(Keys.RETURN);// click on Enter
				By elementLocatore=By.xpath("//h3[text()='Selenium']");
				waitForElemntPressentWithFluentWait(driver, elementLocatore);
			
				
				
				/*  https://www.selenium.dev/documentation/webdriver/waits/
				 * // Waiting 30 seconds for an element to be present on the page, checking
						// for its presence once every 5 seconds.
						Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
						  .withTimeout(Duration.ofSeconds(30))
						  .pollingEvery(Duration.ofSeconds(5))
						  .ignoring(NoSuchElementException.class);

						WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
						  public WebElement apply(WebDriver driver) {
						    return driver.findElement(By.id("foo"));
						  }
						});
						*/
				driver.quit();

	}
	public static WebElement waitForElemntPressentWithFluentWait(WebDriver driver, final By locator){
		FluentWait<WebDriver> wait =new FluentWait<WebDriver> (driver)
		 .withTimeout(Duration.ofSeconds(30))
		  .pollingEvery(Duration.ofSeconds(5))
		  .ignoring(NoSuchElementException.class);
		WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
			  public WebElement apply(WebDriver driver) {
			    return driver.findElement(locator);
			  }
			});
		return ele;
	}

}
