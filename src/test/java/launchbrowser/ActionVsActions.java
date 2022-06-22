package launchbrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionVsActions {

	public static void main(String[] args) {
		// Actions vs Actions
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		WebElement women=driver.findElement(By.xpath("//a[@title='Women']"));
		//Actions is a interface
		Actions act=new Actions(driver);
		//act.moveToElement(women).perform();
		//act.moveToElement(women).build().perform();
		
		//action is class
		Action action=act.moveToElement(women).build();
		action.perform();
		
		driver.quit();

	}

}
