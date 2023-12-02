package qualiautopro.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchpagelocators {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//input[@name='search']")
	WebElement inputtosearchitem;
	
	
	@FindBy(xpath="//span//button[@type='button']")
	WebElement SerchButton;
	
	@FindBy(linkText = "HP LP3065")
	WebElement HPLP306;
	
	
	@FindBy(linkText = "Laptops & Notebooks")
	WebElement HPLaptop;
	
	@FindBy(linkText = "Show AllLaptops & Notebooks")
	WebElement SelectHPlaptopFromtheSearch;
	
	@FindBy(linkText = "HP LP3065")
	WebElement ClickonHPLaptop;
	
	@FindBy(id = "button-cart")
	WebElement AddlaptopToCart;
	
	@FindBy(id="cart-total")
	WebElement CheckingProductIsDisplayedInCart;
	
	@FindBy(xpath="/html/body/header/div/div/div[3]/div/ul/li[2]/div/p/a[1]/strong/i")
	WebElement ClickOnViewCart;
	
	
	public Searchpagelocators(WebDriver driver)
	{
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
	}
	
	//actions
	
	public void Enterinputtosearchitem(String Enterinputtosearchitem)
	{
		inputtosearchitem.sendKeys(Enterinputtosearchitem);
	}
	
	public void Clickonsearchbutton()
	{
		SerchButton.click();
	}
	
	public String checkHPlaptapisdisplayed()
	{
		String searcheditem= "HP LP3065";
		return searcheditem;
	}
	
	public String Checkerrormessage ()
	{
		String Warningmessage="Products meeting the search criteria";
		return Warningmessage;
	}
	public void Clickonlaptopandnotebooklink()
	{
		HPLaptop.click();
	}
	public void SelectingHPLaptop()
	{
		SelectHPlaptopFromtheSearch.click();
	}
	public void ClickonHPlap()
	{
		ClickonHPLaptop.click();
	}
	public void AddToCart()
	{
		AddlaptopToCart.click();
	}
	public void CheckTheCart()
	{
		CheckingProductIsDisplayedInCart.click();
	}
	public void ClickingonViewCartButton()
	{
		ClickOnViewCart.click();
	}

	
}
