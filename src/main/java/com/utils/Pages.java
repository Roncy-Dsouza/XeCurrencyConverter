package com.utils;

import com.xeCurrencyConverter.XeCurrencyconverterScreen;

public class Pages {
    private static <T extends Base> T getPage(Class<T> pageType)  {
        T page;
        try {
            page = pageType.newInstance();
        } catch (InstantiationException e) { //make sure you use JDK 1.8
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return page;
    }

    //This pages class is used in test class
    public static XeCurrencyconverterScreen xeCurrencyconverter(){return getPage(XeCurrencyconverterScreen.class);}

}
