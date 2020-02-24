package pages;

import com.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPageLayoutPage extends Base {
    @FindBy(name = "new")
    private WebElement clickOnNew;

    @FindBy(id = "p1")
    private WebElement typeLayoutName;

    @FindBy(name = "save")
    private WebElement clickOnSave;



    public NewPageLayoutPage(WebDriver driver){
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
}
