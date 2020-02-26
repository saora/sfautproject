package salesforcemaintest;

import com.DriverFactory;
import com.DriverType;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.salesforcemain.ApexClassPage;
import pages.salesforcemain.JsButtonOrLinkPage;
import pages.salesforcemain.SalesforceHomePage;
import pages.salesforcemain.SalesforceLoginPage;

public class NewApexClassTest {
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
    }

    @AfterClass
    public static void tearDown()throws Exception{
/*        if (driver != null) {
            Thread.sleep(6000);
            driver.quit();
        }*/
    }


    @Test()
    public void windowAlertTest(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.setQuickFind("Apex");
        shome.apexClassOption();

        ApexClassPage apexclass = new ApexClassPage(driver);
        apexclass.clickNewApexClass();
        apexclass.typeApexClass();
        apexclass.clickOnSaveApexClass();

    }


}
