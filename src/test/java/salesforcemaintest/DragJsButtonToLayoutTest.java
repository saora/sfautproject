package salesforcemaintest;

import com.DriverFactory;
import com.DriverType;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.salesforcemain.PageLayoutPage;
import pages.salesforcemain.SalesforceHomePage;
import pages.salesforcemain.SalesforceLoginPage;

public class DragJsButtonToLayoutTest {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.get("https://login.salesforce.com/?locale=eu");

        SalesforceLoginPage slogin = new SalesforceLoginPage(driver);
        slogin.typeUsername("leccjsbtnalert.smoketest@de.org");
        slogin.typePassword("test1234");
        slogin.clickLogin();

        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.switchToClassic();

    }

    @Before
    public void doBeforeTest(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.clickOnSetUp();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void loginTest()throws Exception{
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.switchToClassic();
        shome.clickOnCustomizeIcon();
        shome.selCustomizeOption("Campaigns");
        shome.selectObjectOption("Campaign","Page Layouts");

        PageLayoutPage custLayout = new PageLayoutPage(driver);
        custLayout.editLayout("Campaign Layout");
        custLayout.dragAndDropButton("windowalert");



    }
}
