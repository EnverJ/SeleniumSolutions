package launchbrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOperationDoubleClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();

		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//input[@id='field1']")).clear();
		driver.findElement(By.xpath("//input[@id='field1']")).sendKeys("Welcome!!!");
		WebElement copy = driver.findElement(By.xpath("//button[contains(text(),'Copy Text')]"));
		Actions act = new Actions(driver);
		act.doubleClick(copy).perform();

		driver.quit();

	}

}
