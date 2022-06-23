package launchbrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		WebElement min_slider= driver.findElement(By.xpath("//span[1]"));
		System.out.println("Location of the element: "+min_slider.getLocation());//(59, 250)
		System.out.println("Heigh & Width of the elelment: "+min_slider.getSize());//(21, 21)

		
		Actions act=new Actions(driver);
		act.dragAndDropBy(min_slider, 100,0).perform();
		System.out.println("Location of the element: "+min_slider.getLocation());
		System.out.println("Heigh & Width of the elelment: "+min_slider.getSize());
		
		WebElement max_slider= driver.findElement(By.xpath("//span[2]"));
		act.dragAndDropBy(max_slider, -299,0).perform();
	
		
		
		driver.quit();
	}

}
