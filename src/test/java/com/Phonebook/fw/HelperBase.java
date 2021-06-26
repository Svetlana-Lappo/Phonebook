package com.Phonebook.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {

    public  WebDriver wd;

    public HelperBase(WebDriver wd){

        this.wd = wd;
    }

    public void click(By locator, int timeout){

        try{
            new WebDriverWait(wd,timeout).until(ExpectedConditions.elementToBeClickable(locator)).click();
        }catch(WebDriverException wde){
            System.out.println(wde);
        }
    }

    public boolean isElementPresent(By locator, int timeout){

        try{
            new WebDriverWait(wd,timeout).until(ExpectedConditions.elementToBeClickable(locator));
            wd.findElement(locator);
            System.out.println("Element found");
            return true;
        }catch (WebDriverException wde){
            System.out.println("Element not found");
            return false;
        }
    }

    public void type(By locator, int timeout, String inputText){
    try{
        new WebDriverWait(wd,timeout).until(ExpectedConditions.elementToBeClickable(locator));
        wd.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a") + Keys.DELETE +inputText);
        // wd.findElement(locator).clear();
        // wd.findElement(locator).sendKeys(inputText);

    }catch(WebDriverException wde){
        System.out.println(wde);
    }
}
}
