package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class DeleteTodoTest  extends BaseTest {

    @Test
    public void checkAbleToDeleteTodoTask() throws IOException {
        LoginPage loginPage = new LoginPage(driver);  //sending driver to LoginPage
        String actualMsg =
                 loginPage
                .loadPage()
                .validLogin(ConfigUtils.getInstance().getemail(), ConfigUtils.getInstance().getpassword())
                .clickOnAddBtn().addTodoItems("learn selenium")
                .clickOnSubmitBtn()
                .clickOnDeleteBtn()
                .checkNoTodoItemsWhenDelete();
        /*
        builder pattern design used to move from method to another method by using one object like chain
        to use this you have to add return this to each method to link it to other methods
        * */

        String expectedResult = "No Available Todos";
        Assert.assertEquals(actualMsg,expectedResult,"assertion for delete todo item");



    }
}
