package com.xeCurrencyConverter;

import com.utils.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.*;

public class XeCurrencyconverterScreen extends Base {
    private static XeCurrencyconverterRepo dsr;
    public XeCurrencyconverterScreen(){dsr = new XeCurrencyconverterRepo(driver);}


    public boolean isPopupVisible(){
     waitUntilElementIsVisible(dsr.closeButton);
     return (isElementVisible(dsr.closeButton));
    }

    public void clickOnCloseButton(){
        waitUntilElementIsVisible(dsr.closeButton);
        dsr.closeButton.click();
    }

    public boolean isCovertScreenVisible(){
        waitUntilElementIsVisible(dsr.convertButton);
        return (isElementVisible(dsr.convertButton));
    }


    public void navigateBack(){
        driver.navigate().refresh();
        driver.navigate().back();
    }


    public String currencyConverter(String value1,String value2) throws InterruptedException { ;
        Thread.sleep(2000);
        waitUntilElementIsVisible(dsr.fromFieldValue);
        dsr.fromFieldValue.click();
        dsr.fromFieldValue.sendKeys(value1);
        dsr.fromFieldValue.sendKeys(Keys.ENTER);
        dsr.toFieldValue.click();
        waitUntilElementIsVisible(dsr.toFieldValue);
        dsr.toFieldValue.sendKeys(value2);
        dsr.toFieldValue.sendKeys(Keys.ENTER);
        waitUntilElementIsVisible(dsr.convertButton);
        dsr.convertButton.click();
        waitUntilElementIsVisible(dsr.convertedValue.get(0));
        System.out.println("**********************");

        List<WebElement> elems= dsr.convertedValue;
        String resultValue1= elems.get(0).getText();
        String resultValue2= elems.get(1).getText().substring(0,4) ;
        //  String resultValue3= elems.get(1).getText().substring(12,26) ;
        String finalResult= resultValue1 +  resultValue2 ;

        System.out.println(finalResult);

        return finalResult;

    }

    public String convertKESToMUR() throws InterruptedException { ;
        driver.navigate().refresh();
        driver.navigate().back();
        Thread.sleep(2000);
        waitUntilElementIsVisible(dsr.fromFieldValue);
        dsr.fromFieldValue.click();
        dsr.fromFieldValue.sendKeys("AUD");
        dsr.fromFieldValue.sendKeys(Keys.ENTER);
        dsr.toFieldValue.click();
        waitUntilElementIsVisible(dsr.toFieldValue);
        dsr.toFieldValue.sendKeys("CAD");
        dsr.toFieldValue.sendKeys(Keys.ENTER);
        waitUntilElementIsVisible(dsr.convertButton);
        dsr.convertButton.click();
        waitUntilElementIsVisible(dsr.convertedValue.get(0));
        System.out.println("**********************");

        List<WebElement> elems= dsr.convertedValue;
        String resultValue1= elems.get(0).getText();
        String resultValue2= elems.get(1).getText().substring(0,4) ;
        //  String resultValue3= elems.get(1).getText().substring(12,26) ;
        String finalResult= resultValue1 +  resultValue2 ;

        System.out.println(finalResult);
        driver.navigate().back();
        return finalResult;

    }

}
