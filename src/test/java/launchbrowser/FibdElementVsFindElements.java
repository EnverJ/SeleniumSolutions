package launchbrowser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FibdElementVsFindElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		// findElement() --- single webelement
		WebElement serachbox=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		serachbox.sendKeys("XYZ");
		
		// 2. 
		WebElement multiElement=driver.findElement(By.xpath("//body[1]/div[6]/div[4]/div[1]/div[1]/ul[1]/li"));
		System.out.println(multiElement.getText());
		// 3. No such element
//		WebElement noElement=driver.findElement(By.xpath("//body[1]/div[6]/div[4]/div[1]/div[1]/ul[100]/li/.."));
		
		//ii. FindElements---> returns multiple webelements
		List<WebElement> information=driver.findElements(By.xpath("//body[1]/div[6]/div[4]/div[1]/div[1]/ul[1]/li"));
		System.out.println("Number odf elements is "+information.size());
		for(WebElement ele: information){
			System.out.println(ele.getText());
		}
		
	}

}
