package launchbrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerFrame2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");// outer iframe
		driver.switchTo().frame(0); // inner iframe
		
		System.out.println("Text present inside the inner frame: "+driver.findElement(By.xpath("//h1")).getText());
		driver.switchTo().parentFrame();// go to parent frame or outer frame
		String outerText=driver.findElement(By.xpath("//p[text()='You can use the height and width attributes to specify the size of the iframe:']")).getText();
	    System.out.println("Text in te outer iframe: "+outerText);
	    
	    driver.quit();
	}

}
