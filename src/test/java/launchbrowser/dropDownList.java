package launchbrowser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropDownList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/?m=1");
		WebElement animal=driver.findElement(By.xpath("//select[@id='animals']"));
		// Select class--->selectByVisibleText(), selectByValue, selectByIndex
		Select se=new Select(animal);
	se.selectByVisibleText("Baby Cat");
	// use value attribute
	se.selectByValue("cat");
	se.selectByIndex(3);
	
	// selecting option from dd without using methods
	List<WebElement> allOptions=se.getOptions();
	for(WebElement option:allOptions){
		if(option.getText().equals("Cat")){
			option.click();
			break;
		}
	}

	}

}
