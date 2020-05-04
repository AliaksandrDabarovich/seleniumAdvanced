package com.epam.pageobject.test;

import com.epam.pageobject.page.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubjectFieldDraftTest extends BaseTest{

    @Test
    public void verifySubjectFieldInDraft(){
        EmailLoginPage emailLoginPage = new EmailLoginPage((ChromeDriver) driver);
        EmailPage emailPage = emailLoginPage.inputCredentials();
        ComposeEmailPage composeEmailPage = emailPage.composeEmailFromEmailPage();
        EmailPage emailPageAfterCompose = composeEmailPage.composeEmail();
        DraftsPage draftsPage= emailPageAfterCompose.openDraftsPageFromEmailPage();
        DraftEmailPage draftEmailPage = draftsPage.openDraftEmailPage();
        Assert.assertEquals(draftEmailPage.checkSubjectField().getAttribute("value"), "WebDriver", "Incorrect Subject in the Draft");
    }

}
