package com.qnode.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("Test Project execution started");
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		
		String Testcasename= result.getName();
		System.out.println(Testcasename + "Testcase Execution started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String Testcasename=result.getName();
		System.out.println(Testcasename+ "got executed succefully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String Testcasename=result.getName();
		System.out.println(Testcasename+ "got failed");
		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String Testcasename=result.getName();
		System.out.println(Testcasename+ "got skipped");
		System.out.println(result.getThrowable());

		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		String Testcasename=result.getName();
		System.out.println(Testcasename+ "failed due to time out");
		System.out.println(result.getThrowable());
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("All the Testcases execution finished successfully");
		
	}
	
	
	
	
	

}
