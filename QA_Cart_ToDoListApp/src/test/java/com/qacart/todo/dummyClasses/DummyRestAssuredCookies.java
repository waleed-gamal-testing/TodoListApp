package com.qacart.todo.dummyClasses;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

public class DummyRestAssuredCookies {

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(ConfigUtils.getInstance().getBaseUrl());
        driver.manage().window().maximize();
        //Adding cookie from response body from postman from RestAssured Automatically
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        //get restAssured Cookies Automatically
       List<io.restassured.http.Cookie> restAssuredCookies = registerApi.getRestAssuredCookeies();
       for (io.restassured.http.Cookie cookie : restAssuredCookies)
       {
           Cookie seleniumCookie = new Cookie(cookie.getName(),cookie.getValue());
           driver.manage().addCookie(seleniumCookie);
       }
        driver.get(ConfigUtils.getInstance().getBaseUrl());

        Thread.sleep(25000);
        driver.quit();
    }
}