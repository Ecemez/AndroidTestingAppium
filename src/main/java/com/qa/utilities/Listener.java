package com.qa.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.base.TestBase;

import io.appium.java_client.android.AndroidDriver;

public class Listener extends TestBase implements ITestListener{

	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Testcase Failed:" +result.getName());
		String testMethodName = result.getMethod().getMethodName();
		AndroidDriver mobileDriver = null;
		try {
			mobileDriver = (AndroidDriver)result.getTestClass().getRealClass().getDeclaredField("mobileDriver").get(result.getInstance());
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		try {
			takeScreenShotPath(testMethodName, mobileDriver);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Testcase Case Execution Skipped:" +result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Testcase Case Execution Started:" +result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Testcase Passed:" +result.getName());
	}

}
