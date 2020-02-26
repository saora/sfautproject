package pages.salesforcemain;

import com.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApexClassPage extends Base {
    @FindBy(id = "all_classes_page:theTemplate:theForm:newButton")
    private WebElement newApexClass;

    @FindBy(id = "container")
    private WebElement containerApexClass;

    @FindBy(id = "ApexClassEditPage:theTemplate:theForm:thePageBlock:thePageBlockButtons:save")
    private WebElement saveApexClass;

    public ApexClassPage(WebDriver driver){
        super(driver);
    }

    public void clickNewApexClass(){
        clickOnElement(newApexClass);
    }

    public void typeApexClass(){

        WebDriverWait wait =  new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(containerApexClass));

        System.out.println("Text in Apex: "+containerApexClass.getAttribute("style"));
        ((JavascriptExecutor) driver).executeScript("document.getElementById('container').setAttribute('value', 'new value for element')");

        //((JavascriptExecutor) driver).executeScript("document.getElementById('selection_field').setAttribute('value', 'new value for element')");

        //typeTextOnElement(containerApexClass,apexClassText);
    }

    public void clickOnSaveApexClass(){
        clickOnElement(saveApexClass);
    }

}
