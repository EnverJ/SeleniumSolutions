package launchbrowser;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {

	public static void main(String[] args) {
		// TODO Auto-generated method stubWebDriverManager.chromedriver().setup();
/*		How To Locate links in Selenium WebDriver?
				What is the difference between LinkText() and PartialLinkText()?
				How to capture all the links from Web Page?
				What is Broken Link? How to check it?*/
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//1. How To Locate links in Selenium WebDriver?
//		driver.findElement(By.linkText("Today's Deals")).click();
	//	driver.findElement(By.partialLinkText(" Deals")).click(); // partial link text
		
		// 3. how to capture all links
		/*
		List<WebElement> allLink=driver.findElements(By.tagName("a"));
		System.out.println("All links: "+allLink.size());
		for(WebElement linkVal:allLink){
			System.out.println("links: "+linkVal.getText());
			System.out.println(linkVal.getAttribute("href"));
		}
		*/
		
		//4. What is Broken Link? How to check it?*/
		
		
		
driver.quit();
	}


}
