package launchbrowser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		WebElement selectProdType = driver.findElement(By.xpath("//a[contains(text(),'Select Product Type')]"));
		selectProdType.click();
		List<WebElement> typeOp = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		System.out.println(typeOp.size());
		bootstrapDropDown(typeOp, "Cards");
		/*
		 * for(WebElement ptype:typeOp){ if(ptype.getText().equals("Cards")){
		 * ptype.click(); break;
		 * 
		 * } }
		 */

	}

	public static void bootstrapDropDown(List<WebElement> ele, String value) {
		for (WebElement ptype : ele) {
			if (ptype.getText().equals(value)) {
				ptype.click();
				break;

			}
		}
	}
}
