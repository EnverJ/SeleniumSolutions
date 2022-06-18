package launchbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextVsGetAttribute {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/");
		WebElement element=driver.findElement(By.xpath("//input[@id='Email']"));
//		element.clear();
//		Thread.sleep(5000);
//		element.sendKeys("admin@yourstore.com");
		System.out.println(element.getAttribute("value"));
		// getText();
		System.out.println(element.getText());
		
		WebElement loginBtn=driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		System.out.println(loginBtn.getAttribute("type"));
		System.out.println(loginBtn.getText());
	}

}
