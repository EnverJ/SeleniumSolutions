package launchbrowser;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.redbus.com/");
		driver.manage().window().maximize();
	//	driver.switchTo().alert().accept();
		Thread.sleep(5000);
		String year="2023";
		String month="SEP";
		String date="10";
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();// open the date picker
		while(true)
		{
			String monthYear=driver.findElement(By.xpath("(//div[@class='sc-Rmtcm dOGSlJ'])[2]")).getText();
			String arr[]=monthYear.split(" ");
			String mon=arr[0];
			String yr=arr[1];
			if(mon.equalsIgnoreCase(month)|| yr.equalsIgnoreCase(year))
				break;
			else
				driver.findElement(By.xpath("(//div[@class='sc-Rmtcm dOGSlJ'])[3]")).click();
			
		}
		//Date selection
		List<WebElement> allDates=driver.findElements(By.xpath("//div[@class='sc-gPEVay hMMXjS']"));
		for(WebElement ele:allDates){
			String dt=ele.getText();
			if(dt.equalsIgnoreCase(date)){
				ele.click();
				break;
			}
			
		}
		
		
		
		
		driver.quit();

	}

}
