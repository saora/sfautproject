package salesforcemaintest;

import com.DriverFactory;
import com.DriverType;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.salesforcemain.CustomFieldPage;
import pages.salesforcemain.SalesforceHomePage;
import pages.salesforcemain.SalesforceLoginPage;

public class NewCustonFieldTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.get("https://login.salesforce.com/?locale=eu");

        SalesforceLoginPage slogin = new SalesforceLoginPage(driver);
        slogin.typeUsername("glbltest.salesforce@gmail.com");
        slogin.typePassword("test12345");
        slogin.clickLogin();

        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.switchToClassic();
    }

    @AfterClass
    public void tearDown(){

    }

    @Before
    public void beforeTest(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.clickOnSetUp();
        shome.clickOnCustomizeIcon();
    }

    @Test
    public void loginTest(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Campaigns");
        shome.selectObjectOption("Campaign","Fields");

        CustomFieldPage field = new CustomFieldPage(driver);
        field.clickOnNewField();
        field.selectDataType("Text");
        field.clickOnNext();

        field.typeFieldLabel("test");
        field.typeLenght("10");
        field.clickOnNext();
        field.clickOnNext();
        field.clickOnSave();



    }

    @Test
    public void privateFieldForContact(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Contacts");
        shome.selectObjectOption("Contact","Fields");

        CustomFieldPage field = new CustomFieldPage(driver);
        field.clickOnNewField();
        field.selectDataType("Private");
        field.clickOnNext();

        field.typeFieldLabel("test");
        field.typeLenght("10");
        field.clickOnNext();
        field.clickOnNext();
        field.clickOnSave();



    }
}
