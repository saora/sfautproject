package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class Base {

    protected WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }




    public void clickOnElement(WebElement element){
        WebDriverWait wait =  new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public void typeTextOnElement(WebElement element, String textOnElement){
        element.sendKeys(textOnElement);
    }

    public void selectElement(WebElement element, String visibleText){
        Select elementToSelect = new Select(element);
        elementToSelect.selectByVisibleText(visibleText);
    }




}
