package launchbrowser;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadWordFile {

	public static void main(String[] args) {
		
		String Location=System.getProperty("user.dir")+"\\DownLoad";
		// 1. Chrome
		HashMap preference=new HashMap();
		preference.put("download.default_directory", Location);
		
		ChromeOptions option=new ChromeOptions();
		option.setExperimentalOption("prefs", preference);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		
		
		
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();  
		
	/*	//Edge
		HashMap preference=new HashMap();
		preference.put("download.default_directory", Location);
		
		EdgeOptions option=new EdgeOptions();
		option.setExperimentalOption("prefs", preference);
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver(option);
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();  */
		

	}

}
