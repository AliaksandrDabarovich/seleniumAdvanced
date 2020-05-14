package com.epam.pageobject.test;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {
    protected WebDriver driver;

    protected String sendField = "Self: WebDriver";
    protected String hubUrl = "http://localhost:4444/wd/hub";
    protected String webUrl = "http://mail.ru";


    @BeforeClass
    public void setUp() {

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName("firefox");
        try {
            driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get(webUrl);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        driver = null;
    }

}
