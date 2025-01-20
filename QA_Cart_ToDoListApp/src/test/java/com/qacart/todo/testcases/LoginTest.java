package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class LoginTest extends BaseTest {
    /*
    * any Test Class should start with @Test then function of each test
    * */

    @Test
    public void shouldBeAbleLoginWithEmailAndPassword() throws IOException {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        LoginPage loginPage = new LoginPage(driver);  //sending driver to LoginPage  //declare object one time >> builder pattern design
        boolean welomeMsgIsDisplayed =loginPage
                .loadPage()
                .validLogin(ConfigUtils.getInstance().getemail(), ConfigUtils.getInstance().getpassword())
                .validateWelcomeMsg();
         /*
        builder pattern design used to move from method to another method by using one object like chain
        to use this you have to add return this to each method to link it to other methods
        * */
        Assert.assertTrue(welomeMsgIsDisplayed);



    }
}
