package Seleniumscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendorscript {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();//to initialize the browser
		driver.manage().window().maximize(); // to maximise
		driver.get("https://www.redbus.com/");
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("document.getElementById('onward_cal').value='15/11/2023'");//#onward_cal
		driver.quit();
		
	}
}
