package qualiautopro.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpagelocators {
	
	WebDriver driver;
	
	//object
	@FindBy(linkText = "Edit your account information")
	private WebElement Edityouraccountinformation;
	
	//constructor
	public Accountpagelocators(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	//actions
	
	public boolean verifyEditYourAccountInformationIsDisplayed()
	{
		
		boolean displaystatus= Edityouraccountinformation.isDisplayed();
		return displaystatus;
	}

}
