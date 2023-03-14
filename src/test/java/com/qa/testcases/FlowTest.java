package com.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.FlowPage;
import com.qa.pages.SideMenuPage;

import io.appium.java_client.android.AndroidDriver;

public class FlowTest extends TestBase {
	public AndroidDriver mobileDriver;
	
	public void initialize() 
	{
		mobileDriver = initializeDriver();
	}
	
	@Test(description = "Verify context under Help")
	public void verifyHelpTest() throws MalformedURLException, InterruptedException{
	
	FlowPage fp = new FlowPage(mobileDriver);
	fp.accept();
	SideMenuPage sp = fp.clickOnSideMenu();
	Assert.assertTrue(sp.verifyHelpOnDocumentationIsDisplayed(),"Help context");
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testresult) {
		this.mobileDriver.quit();
	}
	
	

}
