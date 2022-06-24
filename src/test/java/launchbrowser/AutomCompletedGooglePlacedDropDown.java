package launchbrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomCompletedGooglePlacedDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		WebElement livePosting = driver.findElement(By.xpath("//a[contains(text(),'Live Posting')]"));
		livePosting.click();
		WebElement searchBox = driver.findElement(By.id("autocomplete"));
		searchBox.clear();
		searchBox.sendKeys("Tokyo");

		String txt;
		do {
			searchBox.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(3000);
			txt = searchBox.getAttribute("value");
			if (txt.equals("Tokyo Metropolitan Area")) {
				searchBox.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(3000);
		}while (!txt.isEmpty());

	}

}
