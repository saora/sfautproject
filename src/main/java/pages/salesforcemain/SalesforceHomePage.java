package pages.salesforcemain;

import com.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SalesforceHomePage extends Base{

   WebElement element;
    WebDriver driver;

    @FindBy(css = ".switch-to-lightning")
    private WebElement toLightning;

    @FindBy(css = ".switch-to-aloha")
    private WebElement toClassicOption;

    @FindBy(css = ".photoContainer")
    private WebElement profileIcon;

    @FindBy(id = "Customize_icon")
    private WebElement customizeIcon;

    @FindBy(className = "parent")
    private List<WebElement> custOption;

    @FindBy(id = "Campaign_icon")
    private WebElement campaignIcon;

    @FindBy(className = "setupFolder")
    private List<WebElement> customizeOptions;

    @FindBy(xpath = "//a[contains(@id,'Campaign')]")
    private List<WebElement> objectOption;

    @FindBy(className = "childContainer")
    private WebElement objectOption1;

    @FindBy(className = "childContainer")
    private  List<WebElement> objectOptions;

    @FindBy(className = "setupHighlightFolder")
    private WebElement setupLeaf;

    @FindBy(xpath = "//*[@id=\"ActionButtonLinkList$ActionsList\"]/div[1]/div/div[1]/table/tbody/tr/td[2]/input[2]")
    private WebElement clickNewButtonorLink;

    @FindBy(id = "setupLink")
    private WebElement setup;

    @FindBy(id = "setupSearch")
    private WebElement quickFind;

    @FindBy(id = "ApexClasses_font")
    private WebElement apexClassOpt;

    public SalesforceHomePage(WebDriver driver){
        super(driver);
    }

    public void clickOnCustomizeIcon(){
        clickOnElement(customizeIcon);
    }

    public void selCustomizeOption(String txtOpt){
        for(int i=0; i<customizeOptions.size(); i++){
            if(customizeOptions.get(i).getText().trim().equals(txtOpt)){
              System.out.println(customizeOptions.get(i).getAttribute("id"));
                customizeOptions.get(i).click();
                //System.out.println(setupLeaf.size());
                break;
            }
        }
    }

    public void selectObjectOption(String objectType, String objectOption){
/*        for(int i=0; i<objectOption.size();i++){
            if(objectOption.get(i).getText().trim().equals("Buttons, Links, and Actions")){
                System.out.println(objectOption.get(i).getAttribute("id"));
                objectOption.get(i).click();
                break;
            }

        }*/



        WebElement element1 = objectOption1;
        List<WebElement> element2 = element1.findElements(By.xpath("//*[@id='"+objectType+"_child']/div/a"));
        System.out.println(element2.size());
        for (WebElement el : element2) {
            if (el.getText().trim().equals(objectOption)) {
                el.click();
                break;
            }
        }
    }

    public void clickOnNewJsButton(){
        clickOnElement(clickNewButtonorLink);
    }

    public void clickOnSetUp(){
        clickOnElement(setup);
    }


    public void switchToLightning() {
        if (this.toLightning.isDisplayed()) {
            this.clickOnElement(this.toLightning);
            System.out.println("It was switched to Lightning");
        } else {
            System.out.println("Classic mode by default");
        }

    }

    public void switchToClassic() {
        try {
            this.clickOnElement(this.profileIcon);
            this.clickOnElement(this.toClassicOption);
            System.out.println("It was switched to classic");
        } catch (Exception var2) {
            System.out.println("Classic mode by default");
        }

    }

    public void setQuickFind(String txtToFind){
        typeTextOnElement(quickFind, txtToFind);
    }

    public void apexClassOption(){
        clickOnElement(apexClassOpt);
    }

}
