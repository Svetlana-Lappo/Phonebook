package com.Phonebook.tests;

import com.Phonebook.modells.DataProviders;
import com.Phonebook.modells.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(app.user().isLoginTabPresent()){
            app.user().logout();
        }
    }


    @Test
public void validRegistrationTest(){
    //go to Login/Registration page

    app.user().clickOnLoginTab();
    //fill Registration form
    app.user().fillRegistrationForm(new User().withEmail("testset1@gmail.com").withPassword("Test_set111"));
    //click on button Registration
    app.user().clickOnRegistrationButton();
    //assert user is registered
   Assert.assertTrue(app.user().isSignOutTabPresent());


}

@Test(dataProvider = "regWithCheckValidEmail", dataProviderClass = DataProviders.class)

    public void registrationTestWithCheckValidEmail(User user){

    //go to Login/Registration page
    app.user().clickOnLoginTab();
    //fill Registration form
    app.user().fillRegistrationForm(user);
    //click on button Registration
    app.user().clickOnRegistrationButton();
    //assert user is registered
    Assert.assertTrue(app.user().isSignOutTabPresent());


}
    @Test(dataProvider = "regWithCheckInvalidEmail", dataProviderClass = DataProviders.class)

    public void negativeRegistrationTestWithCheckInvalidEmail(User user){

        //go to Login/Registration page
        app.user().clickOnLoginTab();
        //fill Registration form
        app.user().fillRegistrationForm(user);
        //click on button Registration
        app.user().clickOnRegistrationButton();
        //assert user is registered
        Assert.assertFalse(app.user().isSignOutTabPresent());


    }
    @Test(dataProvider = "regWithCheckValidPassword", dataProviderClass = DataProviders.class)
    public void RegistrationTestWithCheckValidPassword(User user){

        //go to Login/Registration page
        app.user().clickOnLoginTab();
        //fill Registration form
        app.user().fillRegistrationForm(user);
        //click on button Registration
        app.user().clickOnRegistrationButton();
        //assert user is registered
        Assert.assertTrue(app.user().isSignOutTabPresent());


    }


}
