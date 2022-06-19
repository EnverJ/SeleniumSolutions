package launchbrowser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.tagName("a"));
		int brokenLink = 0;

		for (WebElement ele : links) {
			String url = ele.getAttribute("href");
			if (url == null || url.isEmpty()) {
				System.out.println("URL is empty");
				continue;
			}
			URL link = new URL(url);
			try {
				HttpURLConnection httpconnection = (HttpURLConnection) link.openConnection();
				httpconnection.connect();
				if (httpconnection.getResponseCode() > 400) {
					System.out.println(httpconnection.getResponseCode() + " " + url + " is" + " broken link");
					brokenLink++;
				} else {
					System.out.println(httpconnection.getResponseCode() + " " + url + " is" + " valid link");
				}
			} catch (Exception e) {

			}

		}

		System.out.println("Number of broken links: " + brokenLink);
		driver.quit();

	}

}
