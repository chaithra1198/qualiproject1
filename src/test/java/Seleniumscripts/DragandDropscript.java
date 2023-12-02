package Seleniumscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDropscript {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);// parent class
		//source
		WebElement e1 =driver.findElement(By.id("draggable"));
		WebElement e2=driver.findElement(By.id("droppable"));
		//mouse action

		Actions a=new Actions(driver);
		a.clickAndHold(e1).moveToElement(e2).release().perform();
		Thread.sleep(3000);
		driver.quit();




	}

}
