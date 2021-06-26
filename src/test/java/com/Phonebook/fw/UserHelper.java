package com.Phonebook.fw;

import com.Phonebook.modells.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserHelper extends HelperBase {

    @FindBy(xpath ="//button[contains(text(),'Sign Out')]")
    private WebElement signOutTabElement;

    @FindBy(xpath ="//button[contains(text(),'Registration')]" )
    private WebElement registrationButtonElement;

    @FindBy(css = "input[placeholder='Email']")
    private WebElement emailElement;

    @FindBy(css = "input[placeholder='Password']")
    private WebElement passwordElement;

    @FindBy(css = "a[href='/login']")
    private WebElement logInTabElement;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    private WebElement logInButtonElement;



    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isSignOutTabPresent() {
        return isElementPresent(By.xpath("//button[contains(text(),'Sign Out')]"),5);
        //return isElementPresent(signOutTabElement,5);
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[contains(text(),'Registration')]"),4);
        //click(registrationButtonElement,4);
    }

    public void fillRegistrationForm(User user) {
        type(By.cssSelector("input[placeholder='Email']"),4, user.getEmail());
        //type(emailElement,4, user.getEmail());
        type(By.cssSelector("input[placeholder='Password']"),4,user.getPassword());
        //type(passwordElement,4, user.getPassword());
    }

    public void clickOnLoginTab() {
        click(By.cssSelector("a[href='/login']"),4);
        //click(logInTabElement,4);
    }

    public boolean isLoginTabPresent(){
        return isElementPresent(By.cssSelector("a[href='/login']"), 4);
       // return isElementPresent(logInTabElement,4);

}

    public void clickOnLoginButton() {
        click(By.xpath("//button[contains(text(),'Login')]"),4);
        //click(logInButtonElement,4);
    }

    public void logout() {
        click(By.xpath("//button[contains(text(),'Sign Out')]"),5);
        //click(signOutTabElement,5);
    }
}
