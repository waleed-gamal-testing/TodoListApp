package com.qacart.todo.dummyClasses;

import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class DummyCookies {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(ConfigUtils.getInstance().getBaseUrl());
        driver.manage().window().maximize();
        //Adding cookie from response body from postman manually
        Cookie accessTokenCookie = new Cookie("access_token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY3OGI1NmY0NzlkNGE5MDAxNDQ0NzY2YSIsImZpcnN0TmFtZSI6IndhbGVlZCIsImxhc3ROYW1lIjoiR2FtYWwiLCJpYXQiOjE3MzczMzc1NDN9.AEneYaa2b3W8jGU2D-ifwmlue35EtTcI6QOkFQn7zuU");
        Cookie userIdCookiee = new Cookie("userID","j%3A%22678b56f479d4a9001444766a%22");
        Cookie firstNameCookie = new Cookie("firstName","firstName");
        driver.manage().addCookie(accessTokenCookie);
        driver.manage().addCookie(userIdCookiee);
        driver.manage().addCookie(firstNameCookie);
        driver.navigate().refresh();

        Thread.sleep(25000);
        driver.quit();
    }
}
