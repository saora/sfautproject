package pages.salesforcemain;

import com.Base;
import okio.Timeout;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.util.List;

public class PageLayoutPage extends Base {
    @FindBy(name = "new")
    private WebElement clickOnNew;

    @FindBy(id = "p1")
    private WebElement typeLayoutName;

    @FindBy(name = "save")
    private WebElement clickOnSave;

    @FindBy(id = "troughCategory__Button")
    private WebElement buttonOptFromDropDown;

    @FindBy(id = "quickfind")
    private WebElement findJsButton;

    @FindBy(xpath = "//div[@id='fieldTrough']/table/tbody/tr/td/div/div")
    private WebElement customJsButtonName;

    @FindBy(id = "ext-gen204")
    private WebElement toElement;

    @FindBy(id = "ext-gen51")
    private WebElement savebtnLayout;

   @FindBy(xpath = "//*[@id='LayoutList_body']/table/tbody/tr/th")
   private List<WebElement> layoutList;

//*[@id="LayoutList_body"]/table/tbody/tr/td[1]
@FindBy(xpath = "//*[@id=\"LayoutList_body\"]/table/tbody/tr/td[1]/a[1]")
private WebElement selectLayout;

    public PageLayoutPage(WebDriver driver){
        super(driver);
    }

    public void clickOnNewPageLayout(){
        clickOnElement(clickOnNew);
    }

    public void typeLayoutName(String layoutName){
        typeTextOnElement(typeLayoutName, layoutName);
    }

    public void saveNewLayout(){
        clickOnElement(clickOnSave);
    }

    public void editLayout(String layoutName){
        for(WebElement elayout:layoutList){
            if(elayout.getText().trim().equals(layoutName)){
                clickOnElement(selectLayout);
                break;
            }
        }
    }

    public void dragAndDropButton(String buttonName)throws Exception{
        clickOnElement(buttonOptFromDropDown);

        System.out.println("Js Button Name: "+customJsButtonName.getText());
        typeTextOnElement(findJsButton, buttonName);

        Actions dragdrop = new Actions(driver);

       // dragdrop.clickAndHold(customJsButtonName).build().perform();
       // dragdrop.moveToElement(toElement).build().perform();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(2000,0)");
        Thread.sleep(6000);
       // dragdrop.clickAndHold(customJsButtonName).build().perform();
        dragdrop.dragAndDrop(customJsButtonName, toElement).build().perform();
        Thread.sleep(3000);
        clickOnElement(savebtnLayout);
    }
}

