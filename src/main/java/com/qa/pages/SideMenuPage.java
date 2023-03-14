package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

import io.appium.java_client.android.AndroidDriver;

public class SideMenuPage extends TestBase{

		public AndroidDriver mobileDriver;
		
		@FindBy(xpath = "//['Help & feedback']")
		@CacheLookup
		WebElement helpAndFeedback;
		
		@FindBy(xpath = "//android.view.ViewGroup/android.widget.TextView")
		@CacheLookup
		WebElement helpText;
		
		public SideMenuPage(AndroidDriver mobileDriver) {
			this.mobileDriver = mobileDriver;
			PageFactory.initElements(mobileDriver, this);
			
		}
		
		public void selectHelpAndFeedback() {
			try {
				helpAndFeedback.click();
			} catch (Exception e) {
				throw new RuntimeException("Unable to select Help and Feedback");
			}
		}
		
		public boolean verifyHelpOnDocumentationIsDisplayed() {
			WebDriverWait wait = new WebDriverWait(mobileDriver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup/android.widget.TextView")));
			try {
				return helpText.isDisplayed();
			}catch (Exception e) {
				throw new RuntimeException("Help context = Help on Documentation is not displayed");
			}
			
		}
	
	
}
