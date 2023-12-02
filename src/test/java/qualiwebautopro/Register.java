package qualiwebautopro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qualiwebautopro.util.Base;
import com.qualiwebautopro.util.Utilities;

import qualiautopro.qa.pages.HomepageLocators;
import qualiautopro.qa.pages.Registerpagelocators;

public class Register extends Base {
	WebDriver driver;

	public Register() {
		super();
	}

	@BeforeMethod
	public void setUP() {

		driver = ToInitializethebrowserAndLaunchtheURL(prop.getProperty("browserName"));
		HomepageLocators homepage=new HomepageLocators(driver);
		homepage.ClickonMyAccountbutton();
		homepage.ClickOnRegisterButton();
		
		
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Register")).click();
	}

	@AfterMethod
	public void teardownToclose() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifitheRegisterwithvamandatoryfields() {
		
		Registerpagelocators regpage=new Registerpagelocators(driver);
		regpage.Enterfirstname("chaithra");
		regpage.Enterlasttname("chaithu");
		regpage.EnterEmail(Utilities.generateEmailWithTimeStamp());
		regpage.Entertelephone("8776876787");
		regpage.Enterpassword("12345");
		regpage.Enterconfirmpassword("12345");
		regpage.Clickoncheckbox();
		regpage.clickoncontinuebutton();
		String actualmessage=regpage.successmessageforaccountcreation();
		String expectedmessage= "Your Account Has Been Created!";
		Assert.assertTrue(actualmessage.contains(expectedmessage));
		
		
		
		
		/*driver.findElement(By.id("input-firstname")).sendKeys("chaithra");
		driver.findElement(By.id("input-lastname")).sendKeys("chaithu");
		driver.findElement(By.id("input-email")).sendKeys(utilities.generateEmailTimestamp());
		driver.findElement(By.id("input-telephone")).sendKeys("8776876787");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualmessage = driver.findElement(By.xpath("/html/body/div[2]/div/div/h1")).getText();
		String expectedmessage = "Your Account Has Been Created!";
		AssertJUnit.assertEquals(actualmessage, expectedmessage);*/

	}

	@Test(priority = 2)
	public void verifitheRegisterwithallfields() {
		
		
		Registerpagelocators regpage=new Registerpagelocators(driver);
		regpage.Enterfirstname("chaithra");
		regpage.Enterlasttname("chaithu");
		regpage.EnterEmail(Utilities.generateEmailWithTimeStamp());
		regpage.Entertelephone("8776876787");
		regpage.Enterpassword("12345");
		regpage.Enterconfirmpassword("12345");
		regpage.selectsubscribebutton();
		regpage.Clickoncheckbox();
		regpage.clickoncontinuebutton();
		String actualmessage=regpage.successmessageforaccountcreation();
		String expectedmessage= "Your Account Has Been Created!";
		Assert.assertTrue(actualmessage.contains(expectedmessage));
		
		/*driver.findElement(By.id("input-firstname")).sendKeys("chaithra");
		driver.findElement(By.id("input-lastname")).sendKeys("chaithu");
		driver.findElement(By.id("input-email")).sendKeys(utilities.generateEmailTimestamp());
		driver.findElement(By.id("input-telephone")).sendKeys("8776876787");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualmessage = driver.findElement(By.xpath("/html/body/div[2]/div/div/h1")).getText();
		String expectedmessage = "Your Account Has Been Created!";
		AssertJUnit.assertEquals(actualmessage, expectedmessage);
		System.out.print(expectedmessage);8/*/
	}

	@Test(priority = 3)

	public void verifyRegisterwithEmptyFields() 
	{
		
		Registerpagelocators regpage=new Registerpagelocators(driver);
		regpage.Clickoncheckbox();
		String actualmessage=regpage.Agreetremsandconditionsmessage();
		String expectedmessage= "Warning: You must agree to the Privacy Policy!";
		Assert.assertTrue(actualmessage.contains(expectedmessage));

		
		/*driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualmessage = driver.findElement(By.xpath("//div[text()='Warning: You must agree to the Privacy Policy!']")).getText();
		String expectedmessage = "Warning: You must agree to the Privacy Policy!";
		Assert.assertEquals(actualmessage, expectedmessage);
		System.out.println(expectedmessage);*/
		
		String Warningmessage = driver.findElement(By.xpath("// div[text()='First Name must be between 1 and 32 characters!']")).getText();
		String Errormessage = "First Name must be between 1 and 32 characters!";
		Assert.assertEquals(Warningmessage, Errormessage);
		System.out.println(Errormessage);
		
		String Warninglastname = driver.findElement(By.xpath("// div[text()='Last Name must be between 1 and 32 characters!']")).getText();
		String Errorlastname = "Last Name must be between 1 and 32 characters!";
		Assert.assertEquals(Warninglastname, Errorlastname);
		System.out.println(Errorlastname);

		String warningemail = driver.findElement(By.xpath("//input [@id='input-email']/following-sibling::div")).getText();
		String erroremail = "E-Mail Address does not appear to be valid!";
		Assert.assertEquals(warningemail, erroremail);
		System.out.print(erroremail);
		
		String warningtelephone = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		String errortelephonemessage = "Telephone must be between 3 and 32 characters!";
		Assert.assertEquals(warningtelephone, errortelephonemessage);
		System.out.println(errortelephonemessage);
		
		String warningpassword = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		String errorpassword = "Password must be between 4 and 20 characters!";
		Assert.assertEquals(warningpassword, errorpassword);
		System.out.print(errorpassword);
		// div[text()='First Name must be between 1 and 32 characters!']

	}

}
