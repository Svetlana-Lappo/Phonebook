package com.Phonebook.tests;

import com.Phonebook.modells.Contact;
import com.Phonebook.modells.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {

    @BeforeMethod
    private void ensurePrecondition(){
        app.user().clickOnLoginTab();
        app.user().fillRegistrationForm(new User().withEmail("sarali@gmail.com").withPassword("Sara_Li12"));
        app.user().clickOnLoginButton();
    }

    @Test
    public void validAddContactTest(){
        //click on tab Add
        app.contact().clickOnAddTab();

        //fill contact form
        app.contact().fillContactForm(new Contact().withName("Katrin").withLastName("Boss").withPhone("11111456")
                .withEmail("katboss@gmail.com").withAddress("Foxstr.5").withDescription("kollege"));

        //click on button Save
        app.contact().clickOnSaveButton();

        //new contact card is displayed

       Assert.assertTrue(app.contact().isContactPresentCheckByPhone("11111456"));



    }

}
