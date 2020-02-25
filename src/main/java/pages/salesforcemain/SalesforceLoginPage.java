package pages.salesforcemain;

import com.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalesforceLoginPage extends Base {

    @FindBy(id = "username")
    private WebElement loginUserName;

    @FindBy(id = "password")
    private WebElement loginPassword;

    @FindBy(id = "Login")
    private WebElement loginButton;



    public SalesforceLoginPage(WebDriver driver){
        super(driver);
    }

    public void typeUsername(String textInElement){
        typeTextOnElement(loginUserName, textInElement);
    }

    public void typePassword(String textInelement){
        typeTextOnElement(loginPassword, textInelement);
    }

    public void clickLogin(){
        clickOnElement(loginButton);
    }




}
