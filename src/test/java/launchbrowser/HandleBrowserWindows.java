package launchbrowser;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		/*
		 * 1) How To Handle Browser Windows in Selenium WebDriver?
		 *  2) What is the Difference between getWindowHandle() & getWindowHandles()
		 * methods? 3) How To Switch between Multiple Browser Windows? 4) What
		 * is the difference between close() and quite() methods? 5) How to
		 * close All browser Windows? 6) How To close Specific Browser Window by
		 * choice?
		 */
		
	/*	// getWindowHandle()
		String windowID=driver.getWindowHandle(); // Return single window id
        System.out.println(windowID);
        */
		// getWindowHandles()
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click(); // open another window
		
		Set<String> windowIDs=driver.getWindowHandles();  // IDs of multiple window
		//option 1. using iterator()
/*		Iterator<String> it=windowIDs.iterator();
		String parentID=it.next();// first window ID
		String childID=it.next();
		System.out.println("Parent window ID: "+parentID);
		System.out.println("Child window ID: "+childID);
		*/
		
		// option 2: Using List/ArrayList
		List<String> windoWIDsList=new ArrayList(windowIDs); // Converting Set to List
		
		/*
		String parentID=windoWIDsList.get(0);
		String childID=windoWIDsList.get(1);
		System.out.println("Parent window ID: "+parentID);
		System.out.println("Child window ID: "+childID);
	
		
		// 3) How To Switch between Multiple Browser Windows?
		driver.switchTo().window(parentID);
		System.out.println("parent window title: "+driver.getTitle());
		driver.switchTo().window(childID);
        System.out.println("child window id: "+driver.getTitle());
        */
        // for each loop
/*		for(String windID:windoWIDsList){
			//System.out.println(windID);
			String title=driver.switchTo().window(windID).getTitle();
			System.out.println(title);
		}
        */
		
		for(String windID:windoWIDsList){
			//System.out.println(windID);
			String title=driver.switchTo().window(windID).getTitle();
			System.out.println(title);
			if(title.equals("OrangeHRM")||title.equals("another title")){
				driver.close();
				}
			
			}
        
        Thread.sleep(3000);
//		driver.close(); // close single browser window driver which pinging
        driver.quit();// close all browser windows
        
		
	}
	

}
