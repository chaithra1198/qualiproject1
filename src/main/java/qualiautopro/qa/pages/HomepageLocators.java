package qualiautopro.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
     

	public class HomepageLocators{
		
		
		WebDriver driver;
		
		//these are objects
		
	    @FindBy(xpath="//span[text()='My Account']")
		WebElement MyAccountButton;
	    
	    @FindBy(linkText="Login")
	    WebElement LoginButton;
	    
	    @FindBy(linkText="Register")
	    WebElement Registerbutton;
	   
	    public HomepageLocators(WebDriver driver) //constructor
	    {
	      this.driver=driver;
	      PageFactory.initElements(driver, this);
	    }
		
	    // need to perform action or need to call that objects
	    
	    public void ClickonMyAccountbutton()
	    {
	    	MyAccountButton.click();
	    }
		public void ClickOnLoginButton() 
		
		{
			LoginButton.click();
		}
       public void ClickOnRegisterButton() 
		
		{
	     Registerbutton.click();
		}
		
		

	}
