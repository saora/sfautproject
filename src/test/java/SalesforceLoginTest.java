import com.DriverFactory;
import com.DriverType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.NewButtonOrLinkPage;
import pages.SalesforceHomePage;
import pages.SalesforceLoginPage;

public class SalesforceLoginTest {
    WebDriver driver;

    @Before
    public void setUp(){
        driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.get("https://login.salesforce.com/?locale=eu");
    }

    @After
    public void tearDown(){

    }

    @Test
    public void loginTest(){
        SalesforceLoginPage slogin = new SalesforceLoginPage(driver);
        slogin.typeUsername("glbltest.salesforce@gmail.com");
        slogin.typePassword("test12345");
        slogin.clickLogin();

        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.clickOnCustomizeIcon();
        shome.selCustomizeOption("Campaigns");
        shome.selectObjectOption("Campaign","Buttons, Links, and Actions");
        shome.clickOnNewJsButton();

        NewButtonOrLinkPage jsbtn = new NewButtonOrLinkPage(driver);
        jsbtn.typeLabel("test3");
        jsbtn.typeDescription("Description test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("test content editor");
        jsbtn.saveJavaScriptButton();

    }
}
