package launchbrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		// 2. Explicit Wait, this is element specific. it will wait until
		// designated time(ex: 10s)
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);// click on Enter
		By eleLocator = By.xpath("//h3[text()='Selenium']");

		WebElement ele = waitForElemntPressent(driver, eleLocator, 10);

		ele.click();

		driver.quit();

	}
	
	public static WebElement waitForElemntPressent(WebDriver driver, By locator, int timoeout){
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(timoeout));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
		
	}

}
