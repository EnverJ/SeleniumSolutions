package launchbrowser;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_DropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
	//	driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//input[@id='dob']")).click();// open date picker
		//year selection
		Select month_drp=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month_drp.selectByVisibleText("Oct");
		//month selection
		Select year_drp=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
	    year_drp.selectByVisibleText("1995");
	    // date selection
	    String date="24";
	    List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
	    for(WebElement ele:allDates){
	    	String td=ele.getText();
	    	if(td.equals(date)){
	    		ele.click();
	    		break;
	    	}
	    }
	

	}

}
