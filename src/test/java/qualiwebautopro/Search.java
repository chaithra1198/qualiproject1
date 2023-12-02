package qualiwebautopro;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qualiwebautopro.util.Base;

import qualiautopro.qa.pages.Searchpagelocators;

public class Search extends Base {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUP()
	{
		driver=ToInitializethebrowserAndLaunchtheURL(prop.getProperty("browserName"));
	}
	
	@AfterMethod
	public void TocloseThebrowser()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void searchthePresentItem() 
	{
		
		
		 Searchpagelocators searchpage=new Searchpagelocators(driver);
		 searchpage.Enterinputtosearchitem("HP");
		 searchpage.Clickonsearchbutton();
		 String actualmessage=searchpage.checkHPlaptapisdisplayed();
		 String expectedmessage="HP LP3065";
		 Assert.assertTrue(actualmessage.contains(expectedmessage));
		 
		
		
		  /*driver.findElement(By.xpath("//input[@name='search']")).sendKeys("HP");
		  driver.findElement(By.xpath("//span//button[@type='button']")).click();
		  driver.findElement(By.linkText("HP LP3065")).getText();
		  String expectedmessage="HP LP3065";
		  AssertJUnit.assertTrue(expectedmessage, true);
		  System.out.println("Products meeting the search criteria");*/
      }
	 
	@Test(priority=2)
	public void searchwhichisNotPresentitem()
	{
		 Searchpagelocators searchpage=new Searchpagelocators(driver);
		 searchpage.Enterinputtosearchitem("car");
		 searchpage.Clickonsearchbutton();
		 String actualmessage=searchpage.Checkerrormessage();
		 String expectedmessage="Products meeting the search criteria";
		 Assert.assertTrue(actualmessage.contains(expectedmessage));
		 
		 
		 
		  /*driver.findElement(By.xpath("//input[@name='search']")).sendKeys("car");
		  driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/span/button")).click();
		  String expectedmessage="Products meeting the search criteria";
		  AssertJUnit.assertTrue(expectedmessage, true);*/
	}
    @Test(priority=3)
	public void searchwithempyfield()
	{
    	Searchpagelocators searchpage=new Searchpagelocators(driver);
    	searchpage.Clickonsearchbutton();
    	String actualmessage=searchpage.Checkerrormessage();
    	String expectedmessage="Products meeting the search criteria";
    	Assert.assertTrue(actualmessage.contains(expectedmessage));
    	
    	
    	
		  /*driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/span/button")).click();
		  String expectedmessage="Products meeting the search criteria";
		  AssertJUnit.assertTrue(expectedmessage, true);*/
	}
    
    @Test(priority=4)
    public void seachingHPlaptopandAddTocart() throws InterruptedException 
    { 
    	Searchpagelocators searchpage=new Searchpagelocators(driver);
    	searchpage.Clickonlaptopandnotebooklink();
    	searchpage.SelectingHPLaptop();
    	searchpage.ClickonHPlap();
    	searchpage.AddToCart();
    	String expectedsuccessmessage="Success: You have added HP LP3065 to your shopping cart!";
    	System.out.println(expectedsuccessmessage);
    	searchpage.CheckTheCart();
    	searchpage.ClickingonViewCartButton();
    	System.out.println("Product is added in your shopping cart");
    	
    	
    	//driver.get("https://tutorialsninja.com/demo/");
    	//driver.findElement(By.linkText("Laptops & Notebooks")).click();
    	//driver.findElement(By.linkText("Show AllLaptops & Notebooks")).click();
    	//driver.findElement(By.linkText("HP LP3065")).click();
    	//driver.findElement(By.id("button-cart")).click();
        //Thread.sleep(5000);
        //driver.findElement(By.id("cart-total")).click();
    	//driver.findElement(By.xpath("/html/body/header/div/div/div[3]/div/ul/li[2]/div/p/a[1]/strong/i")).click();
    	
    	
    }
	
	

}
