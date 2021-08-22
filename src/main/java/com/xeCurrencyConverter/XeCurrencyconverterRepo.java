package com.xeCurrencyConverter;

import com.utils.ObjectsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class XeCurrencyconverterRepo extends ObjectsBase {

    public XeCurrencyconverterRepo(WebDriver driver){super(driver);}


    //all the xpaths are stored in this class
    @FindBy(xpath = "//button[@id='yie-close-button-3a534b28-ea6c-5538-a508-4c8236e7647d']")
    protected static WebElement closeButton;

    @FindBy(xpath = "//button[contains(text(),'Convert')]")
    protected static WebElement convertButton;

    @FindBy(xpath = "//input[@id='midmarketFromCurrency']")
    protected static WebElement fromFieldValue;

    @FindBy(xpath = "//input[@id='midmarketToCurrency']")
    protected static WebElement toFieldValue;

    @FindBy(xpath = "//p[contains(@class , 'result')]")
    protected static List<WebElement> convertedValue;


}
