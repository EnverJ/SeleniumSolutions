package launchbrowser;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();

		// 1. Select specific check boxes
		// WebElement monday=driver.findElement(By.id("//input[@id='monday']"));
		// monday.click();
		// 2. Select all the check boxes
		List<WebElement> dayBoxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("total number of checkboxes: " + dayBoxes.size());
/*		for (int i = 0; i < dayBoxes.size(); i += 1) {
			dayBoxes.get(i).click();
		} */
/*		for(WebElement chbox:dayBoxes){
			chbox.click();
		}  */
		
		// 3. Select multiple check boxes by choice
		// select Monday and Saturday
	/*	for(WebElement chbox:dayBoxes){
			String days=chbox.getAttribute("id");
			if(days.equals("monday")|| days.equals("saturday")){
				chbox.click();
			}
		}
		*/
		
		//4. select last few check boxes
		int total=dayBoxes.size();
		for(int i=total-2;i<total;i++){
			dayBoxes.get(i).click();
		}
		Thread.sleep(3000);
		driver.close();
	}

}
