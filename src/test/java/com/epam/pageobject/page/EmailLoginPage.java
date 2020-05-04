package com.epam.pageobject.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class EmailLoginPage extends AbstractPage{

    @FindBy(xpath = "//*[@id='mailbox:login']")
    private WebElement inputEmailField;
    @FindBy(css = "input.o-control")
    private WebElement inputPasswordButton;
    @FindBy(id = "mailbox:password")
    private WebElement inputPasswordField;
    @FindBy(xpath = "//input[@class='o-control']")
    private WebElement inputEnterButton;


    public EmailLoginPage(WebDriver driver) {
        super(driver);
    }

    public EmailPage inputCredentials() {

        waitForVisibility(inputEmailField);
        inputEmailField.sendKeys("aliaksandr.yarkiy@mail.ru");
        inputPasswordButton.click();
        waitForVisibility(inputPasswordField);
        inputPasswordField.sendKeys("obuchenie2015");
        inputEnterButton.click();
        return new EmailPage(driver);
    }


}
