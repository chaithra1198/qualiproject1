package Datepickerfromcalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendardatepicker{
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();
		
		String getmonthAndyear=driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		System.out.println(getmonthAndyear);
		String my[]=getmonthAndyear.split(" ");
		String month=my[0];
		String year=my[1];
		System.out.println(month);
		System.out.println(year);
		
		while((month.equals("january")&& year.equals("2024"))) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			String monthyear1=driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
			month=monthyear1.split(" ")[0];
			year=monthyear1.split(" ")[1];
			
			}
		driver.findElement(By.xpath("//a[text='1']")).click();
		
		
	}

}
