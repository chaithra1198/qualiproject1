package qualiautopro.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpagelocators {
	
	WebDriver driver;
	// objects
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement EmailId;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement Loginbutton;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement InputEmailId;
	
	@FindBy(xpath=" //input[@id='input-password']")
	private WebElement InputPassword;
	
    @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement NomatchforEMailAddressandorPasswordwarning;
    
    @FindBy(linkText = "Change your password")
    private WebElement ChangePassword;
    
    @FindBy(xpath="//input[@id='input-password']")
    private WebElement EnterInputPaswword;
    
    @FindBy(xpath="//input[@name='confirm']")
    private WebElement EnterConfirmPassowrd;
    
    @FindBy(xpath="//input[@type='submit']")
    private WebElement ContinueButton;
    
    @FindBy(xpath="/html/body/div[2]/div[1]")
	private WebElement Yourpasswordhasbeensuccessfullyupdated;
	
    @FindBy(linkText = "Phones & PDAs")
	private WebElement ClickonPhonesPDAs;
	
    @FindBy(linkText = "iPhone")
    private WebElement SelectIphoneLink;
    
    @FindBy(linkText = "Write a review")
    private WebElement Writingreview;
    
    //constructor before executing the script fst need to initialize the browser for that purpose creating constructor and calling this constructor in test method
	
	public Loginpagelocators(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	
	//actions
	
	public void EnterEmailId(String Emailtext)
	{
		
		EmailId.sendKeys(Emailtext);
	}
	
	public void EnterPassword(String passwordtext)
	{
		password.sendKeys(passwordtext);
		
	}
	public void clickonLoginbutton()
	{
		Loginbutton.click();
	}
	public void SendemnailIdtext(String emailtext)
	{
		InputEmailId.sendKeys(emailtext);
	}
	public void Sendpasswordtext(String password)
	{
		InputPassword.sendKeys(password);
		
	}
	public String getwarningtext()
	{
		String warningtext=NomatchforEMailAddressandorPasswordwarning.getText();
		return warningtext;
		
	}
	
	public void ChangeYourPassword()
	{
		ChangePassword.click();
	}
	
	public void EnterNewPassword() 
	{
		EnterInputPaswword.sendKeys("1234567");
	}
	public void EnterNewConfirmPassword() 
	{
		EnterConfirmPassowrd.sendKeys("1234567");
	}
	public void ClickOnContinueButton()
	{
		ContinueButton.click();
	}
	public String getSuccessMessage() {
		String SuccessPasswordChangeMessage="Success: Your password has been successfully updated.";
		return SuccessPasswordChangeMessage;
	}
	
	public void NavigatingToiPhonesandPDAs() 
	{
		ClickonPhonesPDAs.click();
	}
}

