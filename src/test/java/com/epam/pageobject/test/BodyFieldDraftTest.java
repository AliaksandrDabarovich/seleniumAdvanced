package com.epam.pageobject.test;

import com.epam.pageobject.page.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BodyFieldDraftTest extends BaseTest {
    @Test
    public void verifyBodyFieldInDraft (){
        EmailLoginPage emailLoginPage = new EmailLoginPage((ChromeDriver) driver);
        EmailPage emailPage = emailLoginPage.inputCredentials();
        ComposeEmailPage composeEmailPage = emailPage.composeEmailFromEmailPage();
        EmailPage emailPageAfterCompose = composeEmailPage.composeEmail();
        DraftsPage draftsPage= emailPageAfterCompose.openDraftsPageFromEmailPage();
        DraftEmailPage draftEmailPage = draftsPage.openDraftEmailPage();
        Assert.assertEquals(draftEmailPage.checkBodyField().getText(), "Text for test", "Incorrect Text in Body");

    }
}
