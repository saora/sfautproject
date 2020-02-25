package salesforcemaintest;

import com.DriverFactory;
import com.DriverType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.salesforcemain.SalesforceLoginPage;

public class SalesforceLoginTest {
    WebDriver driver;

    @Before
    public void setUp(){
        driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.get("https://login.salesforce.com/?locale=eu");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginTest(){
        SalesforceLoginPage slogin = new SalesforceLoginPage(driver);
        slogin.typeUsername("glbltest.salesforce@gmail.com");
        slogin.typePassword("test12345");
        slogin.clickLogin();
    }
}
