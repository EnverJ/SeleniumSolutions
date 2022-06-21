package launchbrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTablewithPageNation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		
		WebElement username=driver.findElement(By.id("input-username"));
        username.clear();
        username.sendKeys("demo");
        WebElement passwrod=driver.findElement(By.id("input-password"));
        passwrod.clear();
        passwrod.sendKeys("demo");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
   //     driver.findElement(By.xpath("//div[@id='navigation']")).click();
        Thread.sleep(5000);
   //     driver.findElement(By.xpath("//button[@class='btn-close']")).click();
        //Sales--Orders
        driver.findElement(By.xpath("(//a[normalize-space()='Customers'])[1]")).click();
        driver.findElement(By.xpath("(//a[normalize-space()='Customers'])[2]")).click();
        
        // 1. find out total number of pages in the table
        String text=driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
        System.out.println(text);
        int total_pages=Integer.valueOf(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
        System.out.println("Total number of pages: "+total_pages);
        
        // click on every page
        for(int p=1;p<=total_pages;p++){
        	String textFirstPage=driver.findElement(By.xpath("//span[normalize-space()='1']")).getText();
        	System.out.println(textFirstPage);
        }
        
        
        
        driver.quit();
	}

}
