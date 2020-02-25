package salesforcemaintest;

import com.DriverFactory;
import com.DriverType;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.salesforcemain.JsButtonOrLinkPage;
import pages.salesforcemain.SalesforceHomePage;
import pages.salesforcemain.SalesforceLoginPage;

public class NewButtonOrLinkTest {
   static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.get("https://login.salesforce.com/?locale=eu");

        SalesforceLoginPage slogin = new SalesforceLoginPage(driver);
        slogin.typeUsername("glbltest.salesforce@gmail.com");
        slogin.typePassword("test12345");
        slogin.clickLogin();
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.switchToClassic();
    }

    @Before
    public void antes(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.clickOnSetUp();
        shome.clickOnCustomizeIcon();
        shome.selCustomizeOption("Campaigns");
        shome.selectObjectOption("Campaign","Buttons, Links, and Actions");
        shome.clickOnNewJsButton();
    }

    @AfterClass
    public static void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    @Test()
    public void windowAlertTest(){
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("windowalertsmoketest");
        jsbtn.typeDescription("Description test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("test content editor");
        jsbtn.saveJavaScriptButton();
    }
    @Test
    public void alertTest(){
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("alertsmoketest");
        jsbtn.typeDescription("Description test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("test content editor");
        jsbtn.saveJavaScriptButton();
    }

    @Test
    public void apexTest(){
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("apexsmoketest");
        jsbtn.typeDescription("Description test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("test content editor");
        jsbtn.saveJavaScriptButton();
    }
    @Test
    public void ifElseTest(){
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("ifelsesmoketest");
        jsbtn.typeDescription("Description test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("test content editor");
        jsbtn.saveJavaScriptButton();
    }
    @Test
    public void urlFor(){
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("urlforsmoketest");
        jsbtn.typeDescription("Description test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("test content editor");
        jsbtn.saveJavaScriptButton();
    }
    @Test
    public void notSupportedObject(){
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("notsupportedsmoketest");
        jsbtn.typeDescription("Description test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("test content editor");
        jsbtn.saveJavaScriptButton();
    }

}
