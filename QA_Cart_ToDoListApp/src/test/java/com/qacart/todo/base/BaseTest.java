package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.CookieUtils;
import io.restassured.http.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class BaseTest {
    protected WebDriver driver; //declaration WebDriver in this class

    @BeforeMethod
    public void setup()
    {
        driver = new DriverFactory().initialixeDriver();

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
    //convert restAssured cookies to selenium cookies to able to add it to Browser automatically
    public void injectCookiesToBrowsers(List<Cookie>restAssuredCookies)
    {
        List<org.openqa.selenium.Cookie>seleniumCookies=CookieUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
        for (org.openqa.selenium.Cookie cookie : seleniumCookies)
        {
            driver.manage().addCookie(cookie);
        }
    }
}
