package com.Phonebook.tests;

import com.Phonebook.modells.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

  @BeforeMethod
    private void ensurePrecondition(){
      if(!app.user().isLoginTabPresent()){
          app.user().logout();
      }
  }

  @Test()
  public void validLoginTest(){
      //click on Login Tab
      app.user().clickOnLoginTab();

      // fill Login/Registration Form
      app.user().fillRegistrationForm(new User().withEmail("sarali@gmail.com").withPassword("Sara_Li12"));

      //click on Login button
      app.user().clickOnLoginButton();

      //assert user logged
      Assert.assertTrue(app.user().isSignOutTabPresent());
  }

  @Test
    public void invalidLoginTestUnregisteredUser(){
      //click on Login Tab
      app.user().clickOnLoginTab();

      // fill Login/Registration Form
      app.user().fillRegistrationForm(new User().withEmail("Msarali@gmail.com").withPassword("MSara_Li12"));

      //click on Login button
      app.user().clickOnLoginButton();

      //assert user logged
      Assert.assertFalse(app.user().isSignOutTabPresent());

  }

  @Test()
    public void invalidLoginTestWithWrongEmail(){

      //click on Login Tab
      app.user().clickOnLoginTab();

      // fill Login/Registration Form
      app.user().fillRegistrationForm(new User().withEmail("sarali5@gmail.com").withPassword("Sara_Li12"));

      //click on Login button
      app.user().clickOnLoginButton();

      //assert user logged
      Assert.assertFalse(app.user().isSignOutTabPresent());

  }

    @Test()
    public void invalidLoginTestWithWrongPassword(){

        //click on Login Tab
        app.user().clickOnLoginTab();

        // fill Login/Registration Form
        app.user().fillRegistrationForm(new User().withEmail("sarali@gmail.com").withPassword("Sara_Li11"));

        //click on Login button
        app.user().clickOnLoginButton();

        //assert user logged
        Assert.assertFalse(app.user().isSignOutTabPresent());

    }

    @Test
    public void invalidLoginTestWithEmptyFields(){

        //click on Login Tab
        app.user().clickOnLoginTab();

        // fill Login/Registration Form
        app.user().fillRegistrationForm(new User().withEmail("").withPassword(""));

        //click on Login button
        app.user().clickOnLoginButton();

        //assert user logged
        Assert.assertFalse(app.user().isSignOutTabPresent());

    }

    @Test
    public void invalidLoginTestWithEmptyEmail(){

        //click on Login Tab
        app.user().clickOnLoginTab();

        // fill Login/Registration Form
        app.user().fillRegistrationForm(new User().withEmail("").withPassword("Sara_Li12"));

        //click on Login button
        app.user().clickOnLoginButton();

        //assert user logged
        Assert.assertFalse(app.user().isSignOutTabPresent());

    }

    @Test
    public void invalidLoginTestWithEmptyPassword(){

        //click on Login Tab
        app.user().clickOnLoginTab();

        // fill Login/Registration Form
        app.user().fillRegistrationForm(new User().withEmail("sarali@gmail.com").withPassword(""));

        //click on Login button
        app.user().clickOnLoginButton();

        //assert user logged
        Assert.assertFalse(app.user().isSignOutTabPresent());

    }




}
