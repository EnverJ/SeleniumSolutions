package launchbrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		WebElement inputBox=driver.findElement(By.xpath("//input[@id='age']"));
		String toolTip=inputBox.getAttribute("title");
		System.out.println("Tool tip: "+toolTip);
		driver.quit();

	}

}
