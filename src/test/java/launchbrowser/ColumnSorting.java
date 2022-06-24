package launchbrowser;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ColumnSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		WebElement livePosting = driver.findElement(By.xpath("//a[contains(text(),'Live Posting')]"));
		livePosting.click();

		WebElement drpEle = driver.findElement(By.name("category_id"));
		Select se = new Select(drpEle);
		List<WebElement> options = se.getOptions();

		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();

		for (WebElement option : options) {
			originalList.add(option.getText());
			tempList.add(option.getText());

		}
		System.out.println("Original list: " + originalList);
		System.out.println("Temperary List: " + tempList);
		// sort the tempList
		Collections.sort(tempList);// sorting

		System.out.println("Original list after sorting: " + originalList);
		System.out.println("Temperary List after sorting: " + tempList);

		if (originalList.equals(tempList)) {
			System.out.println("DropDown sorted.");
		} else {
			System.out.println("DropDown unsorted.");
		}
		driver.close();

	}

}
