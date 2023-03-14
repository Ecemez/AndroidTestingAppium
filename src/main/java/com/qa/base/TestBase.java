package com.qa.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
	
	public AndroidDriver mobileDriver;
	public String appiumServer = "127.0.0.1";
	public int appiumPort = 4723;
	URL appiumURL = null;
	public static Properties prop;
	
	public TestBase( ) {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com"+ "/qa/config/OR.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public AndroidDriver initializeDriver() {
		try {
			appiumURL = new URL("http://"+ appiumServer + ":" + appiumPort + "/wd/hub");
			this.mobileDriver = new AndroidDriver(appiumURL,setCapabilitiesAndroid());
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return mobileDriver;
		}
	
	public DesiredCapabilities setCapabilitiesAndroid() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir") + "applications"+"com.llamalab.automate_1.31.1-191_minAPI14.apk");
		cap.setCapability("platformVersion", "11.0");
		cap.setCapability("automationName", "UiAutomator2");
		return cap;
	}	
	
	public String takeScreenShotPath(String testCaseName, AndroidDriver mobileDriver) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) mobileDriver;
	@SuppressWarnings("unused")
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir") + "/reports" +testCaseName + ".png";
	return destinationFile;
	}
	
	
}