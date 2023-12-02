package qualiwebautopro;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qualiwebautopro.util.Base;
import com.qualiwebautopro.util.Utilities;

import qualiautopro.qa.pages.Accountpagelocators;
import qualiautopro.qa.pages.HomepageLocators;
import qualiautopro.qa.pages.Loginpagelocators;
public class Loginscript extends Base 
{
	WebDriver driver;
	public Loginscript()
	{
		super();//is used to call superclass methods, and to access the superclass constructor
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		driver=ToInitializethebrowserAndLaunchtheURL(prop.getProperty("browserName"));  //Before method-> test method-> after method
		
		HomepageLocators homepage=new HomepageLocators(driver);
		homepage.ClickonMyAccountbutton();
		homepage.ClickOnLoginButton();
		
		
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Login")).click();
	
	}
	@AfterMethod
	public void Teardown()  
	{
		driver.quit();
		
	}
	
	@Test(priority=1,dataProvider = "Logintestdata")
	public void verifywithvadlidcredetials(String Email,String password)
	{
		Loginpagelocators loginpage=new Loginpagelocators(driver);
		loginpage.EnterEmailId(Email);
		loginpage.EnterPassword(password);
		loginpage.clickonLoginbutton();
		Accountpagelocators accpage=new Accountpagelocators(driver);
		accpage.verifyEditYourAccountInformationIsDisplayed();
		  /*driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		  driver.findElement(By.xpath(" //input[@id='input-password']")).sendKeys(password);
		  driver.findElement(By.xpath("//input[@value='Login']")).click();*/
		  //AssertJUnit.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}
	
	
	@DataProvider(name="Logintestdata") 
	public Object[][] datasupply()
	{
		
		Object[][] data=Utilities.getTestDataFromExcel("Login");
		//Object[][] testdata= {{"chaithraquali@gmail.com","1234"},{"chaithrademo@gmail.com","1234"}};
		return data;	
	}
	
	
	@Test(priority=2)
    public void Loginwithinvalidcredentials()   //if the user is blocked for multiple time login attempt then we use generate time stamp. here it generates dynamic email and pwd everytime
	{
		
		Loginpagelocators loginpage=new Loginpagelocators(driver);
		loginpage.EnterEmailId(Utilities.generateEmailWithTimeStamp());
		///Thread.sleep(4000);
		loginpage.EnterPassword("Chaithra@1234");
		loginpage.clickonLoginbutton();
		String actualmessage=loginpage.getwarningtext();
		String expectedmessage="Warning: No match for E-Mail Address and/or Password";
		Assert.assertTrue(actualmessage.contains(expectedmessage));
		
		
		
		/*driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(utilities.generateEmailTimestamp());
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("schaithravgh" + generateTimestamp()+"@gmail.com");
		//driver.findElement(By.xpath(" //input[@id='input-password']")).sendKeys("Chaithra@1234");
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();	
		String expectedMessae="Warning: No match for E-Mail Address and/or Password.";
		AssertJUnit.assertTrue(actualMessage.contains(expectedMessae));*/

		}
	
	
	
	@Test(priority=3)
	public void LoginwithinvalidEmail() throws InterruptedException
	{   
		Loginpagelocators loginpage=new Loginpagelocators(driver);
		loginpage.EnterEmailId(Utilities.generateEmailWithTimeStamp());  // chaithraTue_Nov_14_11_25_49_IST_2023@gmail.com
		//Thread.sleep(6000);
		loginpage.EnterPassword("Chaithra@542");
		loginpage.clickonLoginbutton();
		String actualmessage=loginpage.getwarningtext();
		String expectedmessage=loginpage.getwarningtext();
		Assert.assertTrue(actualmessage.contains(expectedmessage));
		
		/*driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("schaithravgh123@gmail.com");
		driver.findElement(By.xpath(" //input[@id='input-password']")).sendKeys(prop.getProperty("validpassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualmessage=driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
		String expectedmessage="Warning: No match for E-Mail Address and/or Password";
		AssertJUnit.assertTrue(actualmessage.contains(expectedmessage));
		System.out.print(expectedmessage);*/
	}
	@Test(priority=4)
	public void LoginwithinvalidPassword()
	{
		
		Loginpagelocators loginpage=new Loginpagelocators(driver);
		loginpage.EnterEmailId("schaithravgh@gmail.com");
		loginpage.EnterPassword("Chaithra@12345");
		loginpage.clickonLoginbutton();
		String actualmessage=loginpage.getwarningtext();
		String expectedmessage=loginpage.getwarningtext();
		Assert.assertTrue(actualmessage.contains(expectedmessage));
		
		/*driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("schaithravgh@gmail.com");
		driver.findElement(By.xpath(" //input[@id='input-password']")).sendKeys("Chaithra@1234");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualmessage=driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
		String expectedmessage="Warning: No match for E-Mail Address and/or Password";
		AssertJUnit.assertTrue(actualmessage.contains(expectedmessage));*/
	}
	@Test(priority=5)
	public void verifyloginwithnullfields()
	{
		Loginpagelocators loginpage=new Loginpagelocators(driver);
		loginpage.clickonLoginbutton();
		String actualmessage=loginpage.getwarningtext();
		String expectedmessage=loginpage.getwarningtext();
		Assert.assertTrue(actualmessage.contains(expectedmessage));
		
	}
	
	@Test(priority=6)
	public void ChangeYourPassword() 
	{
		Loginpagelocators loginpage=new Loginpagelocators(driver);
		loginpage.EnterEmailId("practiceuser@gmail.com");
		loginpage.EnterPassword("123456");
		loginpage.clickonLoginbutton();
        loginpage.ChangeYourPassword();
		loginpage.EnterNewPassword();
        loginpage.EnterNewConfirmPassword();
        loginpage.ClickOnContinueButton();
		loginpage.getSuccessMessage();
		
		
		/*String ActualMessage=driver.findElement(By.xpath("/html/body/div[2]/div[1]"));
		String SuccessPasswordChangeMessage="Success: Your password has been successfully updated.";
	    System.out.println(SuccessPasswordChangeMessage);
		Thread.sleep(6000);
		 driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("chaithrapractice@gmail.com");
		//driver.findElement(By.xpath(" //input[@id='input-password']")).sendKeys("Chaithra@5423");
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		//driver.findElement(By.linkText("Change your password")).click();
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Chaithra@54224");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Chaithra@54224");
		driver.findElement(By.xpath("//input[@type='submit']")).click();*/  
	    }
	@Test(priority=7)
	public void  SearchIphoneAndAddToWishList() throws InterruptedException
	{
		
		
		driver.findElement(By.linkText("Phones & PDAs")).click();
		driver.findElement(By.linkText("iPhone")).click();
		driver.findElement(By.linkText("Write a review")).click();
		driver.findElement(By.xpath("//input[@id='input-name']")).sendKeys("chaithra");
		driver.findElement(By.xpath("//textarea[@id='input-review']")).sendKeys("Iphone built to work faster and smoother. Even the old iPhone models work well and have smooth functioning. With excellent internal storage.");
		driver.findElement(By.xpath("//input[@value='4'] ")).click();
		driver.findElement(By.xpath("//button[@id='button-review']")).click();
		WebElement Expectedmessage=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[1]/div/div[2]/form/div[2]"));
		String SuccessMessage="Thank you for your review. It has been submitted to the webmaster for approval.";
		System.out.println(SuccessMessage);
	}
	
	public String generateTimestamp()
	{
		Date date=new Date();
		return (date.toString().replace(" ", "_").replace(":", "_"));
	}
}