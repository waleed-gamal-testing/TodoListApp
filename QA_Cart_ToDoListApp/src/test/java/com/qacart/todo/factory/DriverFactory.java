package com.qacart.todo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {
   private  WebDriver driver ;   // incapsulation concept of OOP >> private  or use it as a local variable in function
    /*
    * environment variable to use it in command lines in maven to run multiple browsers in parallel time
    *  WebDriverManager.chromedriver().setup();    // using webDriber Manager >> use webdriver suitable to version of Google or my browser
    * */
    public WebDriver initialixeDriver()
    {
        // multuple browssers
      // String browser = "CHROME";
        String browser = System.getProperty("browser","CHROME");
       switch (browser)
       {
           case "CHROME":
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
               break ;
           case "FIREFOX":
               WebDriverManager.firefoxdriver().setup();
               driver =new FirefoxDriver();
               break ;
           case "SAFARI":
               // safari not use webdriver manager
               driver = new SafariDriver();
               break;
           default:
               throw new RuntimeException("the browser is not suppoprted to test it ");
       }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;

    }

}
