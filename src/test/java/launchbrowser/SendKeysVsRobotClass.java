package launchbrowser;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendKeysVsRobotClass {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@class='btn block resume-btn btn-orange mt20']")).click();
		
		// susing sendKeys
		//driver.findElement(By.xpath("(//section[@class='modal-body']//div//input[@id='file-upload'])[1]")).sendKeys("C:\\Users\\enlem\\Trust\\EzmetEnver\\DownLoad\\file-sample_100kB.doc");

		//Using Robot Class
		WebElement button=driver.findElement(By.xpath("(//section[@class='modal-body']//div//input[@id='file-upload'])[1]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", button);// click action on the button
		
		//1. copy the location of the file(File path)
		Robot rb=new Robot();
		rb.delay(2000);
		// put the file in clipboard 
		StringSelection ss=new StringSelection("C:\\Users\\enlem\\Trust\\EzmetEnver\\DownLoad\\file-sample_100kB.doc");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		//2. CTRL+V
		rb.keyPress(KeyEvent.VK_CONTROL);// press on CTRL key
		rb.keyPress(KeyEvent.VK_V);// press on V key
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		//3. ENTER
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		
	}

}
