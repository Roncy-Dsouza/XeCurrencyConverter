package com.testbase;

import com.utils.Base;
import com.utils.InitiateDriver;
import com.utils.Pages;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected AppiumDriver appiumDriver;


    @BeforeTest(alwaysRun = true)
    @Parameters({"platform"})
    public void setup(String platform){
        InitiateDriver initiateDriver = new InitiateDriver(platform);
        if(platform.equalsIgnoreCase("Web")) {
            driver = initiateDriver.getDriver();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            Base.driver = driver;
        }else if (platform.equalsIgnoreCase("Mobile"))
        {
            appiumDriver = initiateDriver.getAppiumDriver();
            appiumDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            Base.appiumDriver = appiumDriver;
        }


    }
    @AfterTest(alwaysRun = true)
        public void quitbrowser() throws Exception{
            driver.quit();
        }
    }
