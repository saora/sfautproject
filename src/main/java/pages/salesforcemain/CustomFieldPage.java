package pages.salesforcemain;

import com.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CustomFieldPage extends Base {

    @FindBy(name = "new_field")
    private WebElement clickOnNew;

    @FindBy(xpath = "//*[@name='dtype']")
    private List<WebElement> dataType;

    @FindBy(xpath = "//*[@id='ep']/div/div/table/tbody/tr/td[1]/label")
    private List<WebElement> getDataType;

    @FindBy(id = "")
    private WebElement tdElement;

    @FindBy(name = "goNext")
    private WebElement goNext;

    @FindBy(id = "MasterLabel")
    private WebElement fieldLabel;

    @FindBy(id = "Length")
    private WebElement lenght;

    @FindBy(name = "save")
    private WebElement saveField;




    public CustomFieldPage(WebDriver driver){
        super(driver);
    }

    public void clickOnNewField(){
        clickOnElement(clickOnNew);
    }

    public void selectDataType(String dataTypeToSelect){
        for(int i=0; i<getDataType.size(); i++){
            if(getDataType.get(i).getText().trim().equals(dataTypeToSelect)){
                getDataType.get(i).click();
                System.out.println("Data type Selected: "+getDataType.get(i).getText());
                break;
            }
        }
    }

    public void clickOnNext(){
        clickOnElement(goNext);
    }

    public void clickOnSave(){
        clickOnElement(saveField);
    }

    public void typeFieldLabel(String txtLabel){
        typeTextOnElement(fieldLabel, txtLabel);
    }

    public void typeLenght(String lenghtLabel){
        typeTextOnElement(lenght, lenghtLabel);
    }
}
