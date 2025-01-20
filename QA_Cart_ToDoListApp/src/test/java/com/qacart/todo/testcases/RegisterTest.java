package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest extends BaseTest {

    @Test(enabled = false)
    public void registerWithValidCredentials()
    {


        //homePage
        driver.get("https://qacart-todo.herokuapp.com/");


        WebElement signupLinkText = driver.findElement(By.xpath("//h2[@data-testid=\"signup\"]"));
        signupLinkText.click();

        //Register page
        driver.findElement(By.xpath("//input[@data-testid=\"first-name\"]")).sendKeys("waleed");
        driver.findElement(By.xpath("//input[@data-testid=\"last-name\"]")).sendKeys("Gamal");
        driver.findElement(By.xpath("//input[@data-testid=\"email\"]")).sendKeys("waleedgamal1081996@gmail.com");
        driver.findElement(By.xpath("//input[@data-testid=\"password\"]")).sendKeys("Waleed.Gamal@1996");
        driver.findElement(By.xpath("//input[@data-testid=\"confirm-password\"]")).sendKeys("Waleed.Gamal@1996");
        driver.findElement(By.xpath("//button[@data-testid=\"submit\"]")).click();
    }
}
