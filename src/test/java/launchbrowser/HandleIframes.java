package launchbrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIframes {

	public static void main(String[] args) {
		// iframe have content from different source--iframe tag
		/*
		 * 1) What is the difference between frame and iframe? 2) How To Handle
		 * iframes in Selenium WebDriver? 3) How To Switch between multiple
		 * iFrames? 4) How To Work with Inner iFrames?
		 */
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.selenium.dev/selenium/docs/api/java/overview-summary.html");
		driver.manage().window().maximize();
		//driver.switchTo().frame(index);
		//driver.switchTo().frame(webelement);
		//driver.switchTo().frame(id/name);
		//1. driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();
		driver.switchTo().defaultContent(); // go back to the main page before go to second page. 
		//2. siwitch to second frame
		// driver.switchTo().frame("packageListFrame");
	}

}
