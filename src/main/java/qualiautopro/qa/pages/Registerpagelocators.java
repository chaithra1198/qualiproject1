package qualiautopro.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpagelocators{
	
	WebDriver driver;
	
	
	//objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAccountButtonforRegister;
	
	@FindBy(linkText = "Register")
	private WebElement Registerbutton;
	
	@FindBy(id="input-firstname")
	WebElement Firstnamefield;
	
	@FindBy(id="input-lastname")
	WebElement Lastnamefield;
	
	@FindBy(id="input-email")
	WebElement EmailIdfield;
	
    @FindBy(id="input-telephone")
	WebElement Telephonefield;
    
    @FindBy(id="input-password")
    WebElement Passwordfield;
    
    @FindBy(id="input-confirm")
    WebElement Confirmpasswordfield;
    
    @FindBy(xpath="//input[@type='checkbox']")
    WebElement Selectcheckbox;
    
    @FindBy(xpath="//input[@value='Continue']")
    WebElement Continuebutton;
	
    @FindBy(xpath="/html/body/div[2]/div/div/h1")
    WebElement accountcreationsuccessmessage;
    
    @FindBy(xpath="//input[@name='newsletter']")
    WebElement Subscribebutton;
    
	public Registerpagelocators(WebDriver driver)
	{
	    this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//actions
	
	public void ClickonMyAccountButton()
	{
		MyAccountButtonforRegister.click();
		
	}
	
	public void ClickOnRegisterButton()
	{
		Registerbutton.click();
		
	}
	public void Enterfirstname(String firstName)
	{
		Firstnamefield.sendKeys(firstName);
		
	}
	public void Enterlasttname(String lasttName)
	{
		Lastnamefield.sendKeys(lasttName);
		
	}
	public void EnterEmail(String Emailid)
	{
		EmailIdfield.sendKeys(Emailid);
		
	}
	public void Entertelephone(String telephone)
	{
		Telephonefield.sendKeys(telephone);
		
	}
	public void Enterpassword(String password)
	{
		Passwordfield.sendKeys(password);
	}
	public void Enterconfirmpassword(String confirmpassword)
	{
		Confirmpasswordfield.sendKeys(confirmpassword);
	}
	public void Clickoncheckbox()
	{
		Selectcheckbox.click();
	}
	public void clickoncontinuebutton()
	{
		Continuebutton.click();
	}
	
	public String successmessageforaccountcreation()
	{
		String successmessage=" Your Account Has Been Created!";
		return successmessage;
	}
	
	public void selectsubscribebutton()
	{
		Subscribebutton.click();
	}
	
	public String Agreetremsandconditionsmessage()
	{
		String conditionmessage="Warning: You must agree to the Privacy Policy!";
		return conditionmessage;
				
	}
}


