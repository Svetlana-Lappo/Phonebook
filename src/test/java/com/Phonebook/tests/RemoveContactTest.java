package com.Phonebook.tests;

import com.Phonebook.modells.User;
import com.Phonebook.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {


    @BeforeMethod
    private void ensurePrecondition(){
        app.user().clickOnLoginTab();
        app.user().fillRegistrationForm(new User().withEmail("sarali@gmail.com").withPassword("Sara_Li12"));
        app.user().clickOnLoginButton();

    }

    @Test
    public void removeContactPositiveTest(){
        app.user().click(By.cssSelector("a[href='/contacts']"),4);
        app.user().click(By.xpath("//div[@class='contact-item_card__2SOIM']//h3[text()='01114523678156']"),4);
        app.user().click(By.xpath("//button[text()='Remove']"),4);
        app.user().click(By.cssSelector("a[href='/contacts']"),4);
        //Assert.assertFalse(isElementPresent(By.xpath("//div[@class='contact-item_card__2SOIM']//h3[text()='0123467891']"),4));
        Assert.assertFalse(app.contact().isContactPresentCheckByPhone("01114523678156"));



    }
}
