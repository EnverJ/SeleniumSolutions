package launchbrowser;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*
		 * 1) What is Java Script Alert? 2) How To Handle Java Script Alerts? 3)
		 * How To Handle Authentication Popup? 4) How To Handle Permission
		 * Pop-ups?
		 */
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();

	/*	// Alert window with ok button
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
*/
	/*	//2. Alert window with Ok and Cancel buttons
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
	//	driver.switchTo().alert().accept();// close alert by using Ok button
		driver.switchTo().alert().dismiss();// close alert by using cancel button
		Thread.sleep(3000);
		*/
		
/*		//3. Alert window with input box, capture text from alert
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		Alert alertWindow=driver.switchTo().alert();
		System.out.println("The message displayed on alert: "+alertWindow.getText());
		alertWindow.sendKeys("Welcome");
		alertWindow.accept();
		Thread.sleep(3000);  
		*/
		
		//4. Please check Authenticationpopup class
		driver.quit();
	}

}
