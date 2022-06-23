package launchbrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOperationRightClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/* How To Perform Mouse Operations in Selenium WebDriver?
How to Perform Right click Action?
How to Perform Double click Action?
How to Perform Drag and Drop Action?
How to Perform Mouse Hover Action?
*/
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement btn=driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		Actions act=new Actions(driver);
		act.contextClick(btn).perform();  // perform()==build().perform()
		
		driver.quit();
		
		
	}

}
