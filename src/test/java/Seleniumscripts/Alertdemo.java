package Seleniumscripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertdemo {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();//to initialize the browser
		driver.manage().window().maximize(); // to maximise
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		Alert a =driver.switchTo().alert();
		String arelrtmessage=a.getText();
		System.out.println(arelrtmessage);
		Thread.sleep(4000);
		a.accept();
		driver.findElement(By.id("login1")).sendKeys("abc");
		driver.findElement(By.id("password")).sendKeys("xyz");
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		driver.quit();
		
		
				
	}

}
