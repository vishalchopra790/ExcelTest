package com.Mytests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class NotePadTest {
	public static WindowsDriver driver;

	@BeforeMethod
	public void setup() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
		cap.setCapability("platformName", "windows");
		cap.setCapability("deviceName", "WindowsPC");

		try {
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void cleanup() {
		driver.quit();

	}

	@Test
	public void noteTest() {

		driver.findElementByName("Help").click();
		driver.findElementByName("About Notepad").click();
		driver.findElementByName("OK").click();

	}
	@Test
	public void submitText() {
		driver.findElementByName("Text Editor").sendKeys("This is my first language");
		driver.findElementByName("Text Editor").clear();
	}
	@Test
	public void TimeStamp() throws InterruptedException {
		driver.findElementByName("Edit").click();
		Thread.sleep(3000);
		driver.findElementByAccessibilityId("26").click();
		String value=driver.findElementByName("Text Editor").getAttribute("Value.Value");
		System.out.println(value);
		
		
	}
}
