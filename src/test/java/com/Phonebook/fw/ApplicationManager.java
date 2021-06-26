package com.Phonebook.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager  {

    public WebDriver wd;

    UserHelper user;
    ContactHelper contact;
    String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public UserHelper user() {
        return user;
    }

    public ContactHelper contact() {
        return contact;
    }

    public void init() {

        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if (browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }

        try{
            wd.get("https://contacts-app.tobbymarshall815.vercel.app/home");
        }catch (WebDriverException wde){
            System.out.println(wde);
        }
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        user= new UserHelper(wd);
        contact = new ContactHelper(wd);
    }

    public void stop() {
        wd.quit();
    }


}
