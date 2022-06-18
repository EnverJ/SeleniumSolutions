package launchbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusofWebElement {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	//	WebDriverManager.edgedriver().setup();
		
	//	WebDriver driver=new EdgeDriver();
	//	driver.get("https://frontend.nopcommerce.com");
		
         WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
	//	driver.get("https://frontend.nopcommerce.com");
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		// webelement is isdispalyed()--true or false, isEnable---true or false? Accept the data
		WebElement searchStore=driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"));
		WebElement male=driver.findElement(By.xpath("(//table[@class='inline_grid choices'])[1]/tbody/tr/td/input[@id='RESULT_RadioButton-7_0']"));
		WebElement female=driver.findElement(By.xpath("//label[@for='RESULT_RadioButton-7_1']"));
		
		System.out.println("Display status "+ searchStore.isDisplayed()); // true
		System.out.println("Display status "+ searchStore.isEnabled()); // true
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,450)","");
	//	js.executeScript("argument[0].scrollIntoView()", male);
		// isSelected()
	
		System.out.println(male.isSelected());// false
		System.out.println(female);// false
		
		male.click(); // select the male radio button
		System.out.println(male.isSelected());// true
		System.out.println(female);// false
		
		female.click();
		System.out.println(male.isSelected());//false
		System.out.println(female);// true
		
		driver.quit();
		
		
		
		
		
		

	}

}
