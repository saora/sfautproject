import com.DriverFactory;
import com.DriverType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.PageLayoutPage;
import pages.SalesforceHomePage;
import pages.SalesforceLoginPage;

public class NewPageLayoutTest {
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
    public void loginTest()throws Exception{
        SalesforceLoginPage slogin = new SalesforceLoginPage(driver);
        slogin.typeUsername("glbltest.salesforce@gmail.com");
        slogin.typePassword("test12345");
        slogin.clickLogin();

        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.switchToClassic();
        shome.clickOnCustomizeIcon();
        shome.selCustomizeOption("Campaigns");
        shome.selectObjectOption("Campaign","Page Layouts");

        PageLayoutPage custLayout = new PageLayoutPage(driver);
        custLayout.clickOnNewPageLayout();
        custLayout.typeLayoutName("prueba4");
        custLayout.saveNewLayout();

        custLayout.dragAndDropButton("test2");



    }
}
