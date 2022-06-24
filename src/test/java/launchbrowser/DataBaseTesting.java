package launchbrowser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataBaseTesting {

	public static void main(String[] args) throws InterruptedException, SQLException {
		// add database dependency (Ex: MySQL)
		// DATA
		String cust_firstname = "Tom";
		String cust_lastName = "Jordan";
		String cust_email = "joh09n78@gmail.com";
		String cust_telPhone = "983247523947";
		String cust_passowrd = "John098";

		// User registration
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(cust_firstname);
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(cust_lastName);
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(cust_email);
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(cust_email);

		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(cust_passowrd);

		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();

		String confmsg = driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"))
				.getText();
		//
		try {

			if (confmsg.equals("Your Account Has Been Created!")) {
				System.out.println("Registration sucessful on UI");
			} else {
				System.out.println("Registration not successful!");
			}

		} catch (Exception e) {
			System.out.println("Some problem on UI");
		}

		// DateBase validation
		Connection con = DriverManager.getConnection("jdbc:mysql//localhost:3306/openshop", "root", ""); // root
																											// and
																											// ""
																											// is
																											// username
																											// and
																											// password
		Statement stm = con.createStatement();

		String query = "Select fitstname,lastname, email, telphone from oc_customer";
		ResultSet rs = stm.executeQuery(query);

		boolean status = false;
		while (rs.next())// check the next record, condition is true, code will
							// be excuted

		{
			String fistname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
			String email = rs.getString("email");

			if (cust_firstname.equals(fistname) && cust_lastName.equals(lastname) && cust_email.equals(email)) {
				System.out.println("Record founded in the table || test passed");
				status = true;
				break;
			}

		}
		if (status = false) {
			System.out.println("Record not found in table.|| Test Failed");

		}

	}

}
