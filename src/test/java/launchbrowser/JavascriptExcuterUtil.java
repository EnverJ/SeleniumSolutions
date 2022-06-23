package launchbrowser;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptExcuterUtil {
	 
	
	public static void drawBorder(WebElement elelment, WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", elelment);
	}
	
	public static String getTitleByJs(WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String title=js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static void clickElementByJS(WebElement elelment, WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", elelment);
	}
	
	public static void generateAlert(WebDriver driver,String message){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void refreshBrowserByJS(WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	
	public static void scrollPageDown(WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollPageUp(WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	public static void zoomPageBy(WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("document.body.style.zoom='50%'");// zoom out by 100%
	}
	public static void flash(WebElement elelment,WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String bgColor=elelment.getCssValue("backgroundColor");
		for(int i=0;i<10;i++){
			changeColor("#000000",elelment,driver);//1
			changeColor(bgColor,elelment,driver);
		}  
		
		
	} 
	public static void changeColor(String color, WebElement element,WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor ='"+ color +"'", element);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			
		}
	}
		
	
	
	

}
