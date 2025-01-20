package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TodoCookiesTest extends BaseTest {


    @Test(enabled = false)
    public void addTodoItem() throws IOException {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
         //add all cookies to browser but we need it after load a page

        TodoPage todoPage = new TodoPage(driver);
        todoPage.load(); /* get url of todo page direct but maybe all cookies was removed */
        injectCookiesToBrowsers(registerApi.getRestAssuredCookeies()); // add all cookies to browser

        String actualResult =
                         todoPage.load()  // refresh for page to use cookies to login by user id , access token
                        .clickOnAddBtn()
                        .addTodoItems("learn selenium")
                        .clickOnSubmitBtn()
                        .validateTextInTodoBox();
        /*
        builder pattern design used to move from method to another method by using one object like chain
        to use this you have to add return this to each method to link it to other methods
        * */

        String expectedResult = "learn selenium";
        Assert.assertEquals(actualResult, expectedResult, "assert that todo item is added successfully");

    }
}
