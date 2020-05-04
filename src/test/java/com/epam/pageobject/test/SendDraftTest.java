package com.epam.pageobject.test;

import com.epam.pageobject.page.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendDraftTest extends BaseTest {
    @Test
    public void sendDraft(){
        EmailLoginPage emailLoginPage = new EmailLoginPage((ChromeDriver) driver);
        EmailPage emailPage = emailLoginPage.inputCredentials();
        ComposeEmailPage composeEmailPage = emailPage.composeEmailFromEmailPage();
        EmailPage emailPageAfterCompose = composeEmailPage.composeEmail();
        DraftsPage draftsPage= emailPageAfterCompose.openDraftsPageFromEmailPage();
        DraftEmailPage draftEmailPage = draftsPage.openDraftEmailPage();
        AdvertisingPage advertisingPage = draftEmailPage.sendDraft();
        DraftsPage draftsPageAfterSendingDraft = advertisingPage.closeAdvertising();
        Assert.assertTrue(draftsPageAfterSendingDraft.verifyDraftSend()!=null,"Draft was not sent");
    }

}
