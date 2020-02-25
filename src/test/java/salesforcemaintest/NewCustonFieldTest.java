package salesforcemaintest;

import com.DriverFactory;
import com.DriverType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.salesforcemain.CustomFieldPage;
import pages.salesforcemain.SalesforceHomePage;
import pages.salesforcemain.SalesforceLoginPage;

public class NewCustonFieldTest {
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
        shome.switchToClassic();
        shome.clickOnCustomizeIcon();
        shome.selCustomizeOption("Campaigns");
        shome.selectObjectOption("Campaign","Fields");

        CustomFieldPage field = new CustomFieldPage(driver);
        field.clickOnNewField();
        field.selectDataType("Text");
        field.clickOnNext();

        field.typeFieldLabel("fieldTest");
        field.typeLenght("10");
        field.clickOnNext();
        field.clickOnNext();
        field.clickOnSave();



    }
}
