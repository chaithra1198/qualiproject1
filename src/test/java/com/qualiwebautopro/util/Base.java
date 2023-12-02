package com.qualiwebautopro.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {

	public static ExtentReports extentreports;
	public static ExtentTest extentTest;
	public WebDriver driver;
	public Properties prop;

	public Base()
	{
		prop = new Properties();// to use this properties which is inbuilt need to create constructor used to access config file..
		File propFile=new File(System.getProperty("user.dir")+"/src/main/java/com/qualiwebautopro/config/config.properties");


		try {

			FileInputStream fis = new FileInputStream(propFile);// to read the file
			prop.load(fis);

		}catch(Throwable e) 
		{
			e.printStackTrace();

		}
	}


	public  WebDriver ToInitializethebrowserAndLaunchtheURL(String browserName)
	{

		if(browserName.equalsIgnoreCase("chrome"))
		{    
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{	
			driver=new FirefoxDriver();	
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
	}

	// Methods for Extent Reporting

	@BeforeTest
	public void getnameMethod(ITestContext context) {

		extentTest = extentreports.createTest(context.getName());
	}

	@BeforeSuite
	public void InitExentReport() {

		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("testreport_extent.html");
		extentreports = new ExtentReports();
		extentreports.attachReporter(sparkreporter);

		extentreports.setSystemInfo("Operating Sytsem : ", System.getProperty("os.name"));
		extentreports.setSystemInfo("JAVA Version : ", System.getProperty("java.version"));

	}

	// To Generate the extent report
	@AfterSuite
	public void generateReports() throws IOException {

		extentreports.flush();
		Desktop.getDesktop().browse(new File("testreport_extent.html").toURI());
	}

	@AfterMethod
	public void generateStatus(Method m, ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			System.out.println("Caputre the screenshot on failure");
			extentTest.fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			extentTest.pass(m.getName() + "  is passed");
		}

	}


}