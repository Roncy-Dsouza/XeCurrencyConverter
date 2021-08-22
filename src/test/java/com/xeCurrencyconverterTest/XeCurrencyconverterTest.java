package com.xeCurrencyconverterTest;

import com.utils.Pages;
import com.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class XeCurrencyconverterTest extends TestBase {

    String EURtoGBP= "1.00 Euro =0.85";
    String INRtoGBP= "1.00 Indian Rupee =0.00";
    String AUDtoCAD= "1.00 Australian Dollar =0.91";
    String KEStoMUR= "1.00 Kenyan Shilling =0.38";
    String SGDtoZAR= "1.00 Singapore Dollar =11.2";

    @Test(priority = 1)
    public void navigateToPopularShows(){
        driver.get("http://www.xe.com/currencyconverter/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        Assert.assertTrue(Pages.xeCurrencyconverter().isPopupVisible(),"Failed to load the Xe Currency Converter");
    }
    @Test(priority = 2)
    public void closeThePopup(){
        Pages.xeCurrencyconverter().clickOnCloseButton();
        Assert.assertTrue(Pages.xeCurrencyconverter().isCovertScreenVisible(),"Failed to close the popup");
    }

    @Test(priority = 3)
    public void convertOneEURToGBP() throws InterruptedException {
        String eur= "EUR";
        String gbp= "GBP";
        Assert.assertEquals(Pages.xeCurrencyconverter().currencyConverter(eur,gbp),EURtoGBP,"Failed to verify the Euro to British Pound Convertion");
    }

    @Test(priority = 4)
    public void convertOneINRToGBP() throws InterruptedException {
        String inr= "INR";
        String gbp= "GBP";
        Pages.xeCurrencyconverter().navigateBack();
        Assert.assertEquals(Pages.xeCurrencyconverter().currencyConverter(inr,gbp),INRtoGBP,"Failed to verify the INR to British Pound Convertion");
    }

    @Test(priority = 5)
    public void convertOneAUDToCAD() throws InterruptedException {
        String aud= "AUD";
        String cad= "CAD";
        Pages.xeCurrencyconverter().navigateBack();
        Assert.assertEquals(Pages.xeCurrencyconverter().currencyConverter(aud,cad),AUDtoCAD,"Failed to verify the AUD to CAD Convertion");
    }

    @Test(priority = 6)
    public void convertOneKESToMUR() throws InterruptedException {
        String kes= "KES";
        String mur= "MUR";
        Pages.xeCurrencyconverter().navigateBack();
        Assert.assertEquals(Pages.xeCurrencyconverter().currencyConverter(kes,mur),KEStoMUR,"Failed to verify the KES to MUR Convertion");
    }

    @Test(priority = 7)
    public void convertOneSGDToZAR() throws InterruptedException {
        String sgd= "SGD";
        String zar= "ZAR";
        Pages.xeCurrencyconverter().navigateBack();
        Assert.assertEquals(Pages.xeCurrencyconverter().currencyConverter(sgd,zar),SGDtoZAR,"Failed to verify the SGD to ZAR Convertion");
    }

}
