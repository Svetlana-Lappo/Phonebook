package com.Phonebook.fw;

import com.Phonebook.modells.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactHelper extends HelperBase {




    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isContactPresentCheckByPhone(String phone) {
        return isElementPresent(By.xpath("//div[@class='contact-item_card__2SOIM']//h3[text()=" + phone + "]"), 4);
    }

    public void clickOnSaveButton() {
        click(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/button[1]"),4);
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("input[placeholder='Name']"),4,contact.getName());
        type(By.cssSelector("input[placeholder='Last Name']"),4,contact.getLastName());
        type(By.cssSelector("input[placeholder='Phone']"),4, contact.getPhone());
        type(By.cssSelector("input[placeholder='email']"),4,contact.getEmail());
        type(By.cssSelector("input[placeholder='Address']"),4, contact.getAddress());
        type(By.cssSelector("input[placeholder='description']"),4, contact.getDescription());
    }

    public void clickOnAddTab() {
        click(By.cssSelector("a[href='/add']"),4);
    }
}
