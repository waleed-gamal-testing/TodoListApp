package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {
    //constructor
    public NewTodoPage(WebDriver driver)
    {
        super(driver);
    }

    //locators
    @FindBy(xpath = "//input[@data-testid=\"new-todo\"]")
    private WebElement textArea ;

    @FindBy(xpath = "//button[@data-testid=\"submit-newTask\"]")
    private WebElement submitBtn ;

    @FindBy(xpath = "//h2[@data-testid=\"back\"]")
    private WebElement backLinkText ;

    //Actions
    public NewTodoPage addTodoItems (String todoItem)
    {
        textArea.sendKeys(todoItem);
        return this;

    }
    public TodoPage clickOnSubmitBtn()
    {
        submitBtn.click();
        return new TodoPage(driver);
    }
    public TodoPage clickOnBackLinkText()
    {
        backLinkText.click();
        return new TodoPage(driver);
    }
}
