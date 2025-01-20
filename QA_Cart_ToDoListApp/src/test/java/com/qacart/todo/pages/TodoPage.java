package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class TodoPage extends BasePage {
    //constructor
    public TodoPage(WebDriver driver)
    {
        super(driver);
    }
    //locators
    @FindBy(xpath = "//*[@data-testid=\"add\"]")
    private WebElement textBoxAddBtn ;

    @FindBy(xpath = "//h2[@data-testid=\"welcome\"]")
    private WebElement welcomeMsg ;

    @FindBy(xpath = "//h4[@data-testid=\"no-todos\"]")
   private WebElement noTodoMsg ;

    @FindBy(xpath = "//h2[@data-testid=\"todo-text\"]")
    private WebElement todoText ;


    @FindBy(xpath = "//input[@type=\"checkbox\"]")
    private WebElement checkBox ;

    @FindBy(xpath = "//button[@data-testid=\"delete\"]")
    private WebElement deleteBtn ;

    //Actioopns
    public boolean validateWelcomeMsg()
    {
       return  welcomeMsg.isDisplayed();
    }
    public NewTodoPage clickOnAddBtn()
    {
        textBoxAddBtn.click();
        return new NewTodoPage(driver);
    }
    public String validateTextInTodoBox()
    {
        return todoText.getText();
    }
    public boolean validateFunctionalityOfCheckBox()
    {
        return  checkBox.isEnabled();
    }
    public TodoPage clickOnDeleteBtn()
    {
        deleteBtn.click();
        return this;
    }
    public String checkNoTodoItemsWhenDelete()
    {
        return noTodoMsg.getText();
    }
    public TodoPage load() throws IOException {
        driver.get(ConfigUtils.getInstance().getBaseUrl()+"/todo");
        return this;

    }


}
