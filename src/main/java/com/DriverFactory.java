package com;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    static WebDriver driver;

    public static WebDriver getDriver(DriverType type){
        switch (type){
            case CHROME:
                System.setProperty("webdriver.chrome.driver","src/main/resources/webdriver/widows/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver","src/main/resources/webdriver/widows/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
                default:
                    System.out.println("Driver not found!!");
                    break;
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;

    }


}
