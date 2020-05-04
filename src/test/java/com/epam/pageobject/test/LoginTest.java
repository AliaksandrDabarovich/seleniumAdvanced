package com.epam.pageobject.test;

import com.epam.pageobject.page.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void login () {

        EmailLoginPage emailLoginPage = new EmailLoginPage((ChromeDriver) driver);
        EmailPage emailPage = emailLoginPage.inputCredentials();
        Assert.assertTrue(emailPage.getSentButton() != null, "User is not logged in");
    }


}
