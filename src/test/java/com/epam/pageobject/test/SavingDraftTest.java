package com.epam.pageobject.test;

import com.epam.pageobject.page.ComposeEmailPage;
import com.epam.pageobject.page.DraftsPage;
import com.epam.pageobject.page.EmailLoginPage;
import com.epam.pageobject.page.EmailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SavingDraftTest extends BaseTest {

    @Test

    public void saveToDraft () {
        EmailLoginPage emailLoginPage = new EmailLoginPage(driver);
        EmailPage emailPage = emailLoginPage.inputCredentials();
        ComposeEmailPage composeEmailPage = emailPage.composeEmailFromEmailPage();
        EmailPage emailPageAfterCompose = composeEmailPage.composeEmail();
        DraftsPage draftsPage= emailPageAfterCompose.openDraftsPageFromEmailPage();
        Assert.assertTrue(draftsPage.checkEmailInDrafts()!=null, "Email is not saved in drafts");
    }

}
