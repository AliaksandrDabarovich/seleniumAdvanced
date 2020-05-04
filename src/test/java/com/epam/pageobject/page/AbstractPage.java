package com.epam.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 10;


    protected AbstractPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    protected WebElement waitForVisibility(WebElement element) {
       return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(element));

    }
    protected WebElement fluentWaitForVisibility (WebElement element) {
       return new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).pollingEvery(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(element));

    }
    protected WebElement waitElement(By by){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(by));
    }
    protected WebElement waitTillElementClickable(WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
