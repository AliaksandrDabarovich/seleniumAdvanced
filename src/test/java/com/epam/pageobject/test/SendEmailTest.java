package com.epam.pageobject.test;

import com.epam.pageobject.page.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendEmailTest extends BaseTest {
    @Test
    public void deliverEmail (){
        EmailLoginPage emailLoginPage = new EmailLoginPage(driver);
        EmailPage emailPage = emailLoginPage.inputCredentials();
        ComposeEmailPage composeEmailPage = emailPage.composeEmailFromEmailPage();
        EmailPage emailPageAfterCompose = composeEmailPage.composeEmail();
        DraftsPage draftsPage= emailPageAfterCompose.openDraftsPageFromEmailPage();
        DraftEmailPage draftEmailPage = draftsPage.openDraftEmailPage();
        AdvertisingPage advertisingPage = draftEmailPage.sendDraft();
        DraftsPage draftsPageAfterSendingDraft = advertisingPage.closeAdvertising();
        SendEmailPage sendEmailPage = draftsPageAfterSendingDraft.openSendEmailPage();
        Assert.assertEquals(sendEmailPage.deliverEmail().getText(), sendField,"Email is not delivered");
        EmailLoginPage emailLoginPageAfterSendEmail = sendEmailPage.logOut();
    }
}
