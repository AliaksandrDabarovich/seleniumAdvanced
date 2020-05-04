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
//
//
//        ComposeEmailPage composeEmailPage = emailPage.composeEmailFromEmailPage();
//        EmailPage emailPageAfterCompose = composeEmailPage.composeEmail();
//        DraftsPage draftsPage= emailPageAfterCompose.openDraftsPageFromEmailPage();
//        Assert.assertTrue(draftsPage.checkEmailInDrafts()!=null, "Email is not saved in drafts");
//
//        DraftEmailPage draftEmailPage = draftsPage.openDraftEmailPage();
//        Assert.assertEquals(draftEmailPage.checkToField().getText(), "aliaksandr.yarkiy@mail.ru", "Incorrect Email");
//        Assert.assertEquals(draftEmailPage.checkSubjectField().getAttribute("value"), "WebDriver", "Incorrect Subject in the Draft");
//        Assert.assertEquals(draftEmailPage.checkBodyField().getText(), "Text for test", "Incorrect Text in Body");
//
//        AdvertisingPage advertisingPage = draftEmailPage.sendDraft();
//        DraftsPage draftsPageAfterSendingDraft = advertisingPage.closeAdvertising();
//        Assert.assertTrue(draftsPageAfterSendingDraft.verifyDraftSend()!=null,"Draft was not sent");
//
//        SendEmailPage sendEmailPage = draftsPageAfterSendingDraft.openSendEmailPage();
//        Assert.assertEquals(sendEmailPage.deliverEmail().getText(), "Self: WebDriver","Email is not delivered");
//        EmailLoginPage emailLoginPageAfterSendEmail = sendEmailPage.logOut();


    }


}
