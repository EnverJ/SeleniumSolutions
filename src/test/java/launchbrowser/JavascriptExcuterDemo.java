package launchbrowser;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExcuterDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		// JavaScriptExcuter is an interface
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		
		
		//syntax
	/*	JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(key, args);
            */		
		// flash an element(highlighting an element)
		JavascriptExcuterUtil.flash(logo, driver);
		
		
		
		//drawing border & take screenshot
	//	WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavascriptExcuterUtil.drawBorder(logo, driver);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\screenshots\\logoJS.png");
		FileUtils.copyFile(src, trg);
		
		
		
		// Getting title of the page
		String title=JavascriptExcuterUtil.getTitleByJs(driver);
		System.out.println("Title of the page : "+title);
		
		//click action
//		WebElement reglink=driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
//		JavascriptExcuterUtil.clickElementByJS(reglink, driver);
		
		//generate alert
//		JavascriptExcuterUtil.generateAlert(driver, "You are on Register page!!!");
		
		
		//Refreshing the page
		JavascriptExcuterUtil.refreshBrowserByJS(driver);
		
		// scroll down/up the page
		JavascriptExcuterUtil.scrollPageDown(driver);
		Thread.sleep(3000);
		JavascriptExcuterUtil.scrollPageUp(driver);
		
		// zoom page
//		JavascriptExcuterUtil.zoomPageBy(driver);
		
		
		
	//	driver.quit();

	}

}
