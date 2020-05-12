package com.epam.pageobject.test;

import com.epam.pageobject.page.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToFieldInDraftTest extends BaseTest {

    @Test
    public void verifyToFieldInDraft () {
        EmailLoginPage emailLoginPage = new EmailLoginPage(driver);
        EmailPage emailPage = emailLoginPage.inputCredentials();
        ComposeEmailPage composeEmailPage = emailPage.composeEmailFromEmailPage();
        EmailPage emailPageAfterCompose = composeEmailPage.composeEmail();
        DraftsPage draftsPage= emailPageAfterCompose.openDraftsPageFromEmailPage();
        DraftEmailPage draftEmailPage = draftsPage.openDraftEmailPage();
        Assert.assertEquals(draftEmailPage.checkToField().getText(), draftEmailPage.getEmail(), "Incorrect Email");

    }

}
