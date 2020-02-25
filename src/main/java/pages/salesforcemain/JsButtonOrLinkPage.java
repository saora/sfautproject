package pages.salesforcemain;

import com.Base;
import jdk.nashorn.internal.runtime.ECMAException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Calendar;
import java.util.List;

public class JsButtonOrLinkPage extends Base {

    @FindBy(id = "MasterLabel")
    private WebElement label;

    @FindBy(id = "WebLinkFields_Name")
    private WebElement name;

    @FindBy(id = "Description")
    private WebElement description;

    @FindBy(name = "WebLinkFields_DisplayType")
    private List<WebElement> displayType;

    @FindBy(id = "OpenType")
    private WebElement behavior;

    @FindBy(id = "WebLinkFields_ContentEditor")
    private WebElement contentEditor;

    @FindBy(name = "save_close")
    private WebElement saveJsButton;


    public JsButtonOrLinkPage(WebDriver driver){
        super(driver);
    }

    public void typeLabel(String texInLabel){
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int monthOfYear=cal.get(Calendar.MONTH);

        String dayOfMonthStr = String.valueOf(dayOfMonth);
        String monthOfYearStr = String.valueOf(monthOfYear+1);

        typeTextOnElement(label, texInLabel+dayOfMonthStr+monthOfYearStr);
    }

    public void typeName(String textInName){
        typeTextOnElement(name, textInName);
    }

    public void typeDescription(String textInDescription){
        typeTextOnElement(description, textInDescription);
    }

    public void selectDisplayType(String selDispType) {
        switch (selDispType) {
            case "Detail Page Link":
                displayType.get(0).click();
                System.out.println("Display selected: "+displayType.get(0).getAttribute("id"));
                break;
            case "Detail Page Button":
                displayType.get(1).click();
                System.out.println("Display selected: "+displayType.get(1).getAttribute("id"));
                break;
            case "List Button":
                displayType.get(2).click();
                System.out.println("Display selected: "+displayType.get(2).getAttribute("id"));
                break;
        }
    }


    public void selectBehavior(String dispType) {
        selectElement(behavior, dispType);
    }

    public void typeContentEditor(String textIncontentEditor){
        typeTextOnElement(contentEditor, textIncontentEditor);
    }

    public void saveJavaScriptButton(){
            clickOnElement(saveJsButton);
            try{
                driver.switchTo().alert().accept();
            }catch (Exception e){
                System.out.println("Alert not present");
            }


    }

}
