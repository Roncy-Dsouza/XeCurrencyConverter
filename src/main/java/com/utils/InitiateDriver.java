package com.utils;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class InitiateDriver {
    private WebDriver driver;
    private AppiumDriver appiumDriver;


    public InitiateDriver(String platform){
        //To launch the  chrome browser, no need to exe of remote server to be running
        if(platform.equalsIgnoreCase("Web")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(platform.equalsIgnoreCase("Mobile")){
            File app = new File("./src/main/resources/Test.apk");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "Lenovo A7020a48");
            capabilities.setCapability("platformName", "Android");
            //Change the version of android device here
            capabilities.setCapability("platformVersion", "6.0");
            capabilities.setCapability("app", app);
            capabilities.setCapability("appPackage", "com.test.customer");
            capabilities.setCapability("appActivity", "com.test.customer.view.activity.SplashActivity");

            try {
                FileInputStream file = new FileInputStream("./src/main/resources/config.properties");
                Properties prop = new Properties();
                prop.load(file);
                //appium server url is stored in config.properties file
                String appiumserver = prop.getProperty("AndroidAppURL");

                appiumDriver = new AndroidDriver(new URL(appiumserver), capabilities);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }


    public WebDriver getDriver()
    {
        //custom exception if driver is not initiated
        if(driver==null)
            throw new RuntimeException("Driver has not been Instantiated or exe files are missing");

        return driver;
    }

    public AppiumDriver getAppiumDriver()
    {
        //custom exception if driver is not initiated
        if(driver==null)
            throw new RuntimeException("Driver has not been Instantiated or exe files are missing");

        return appiumDriver;
    }


}
