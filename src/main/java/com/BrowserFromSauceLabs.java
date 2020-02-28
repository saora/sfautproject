package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class BrowserFromSauceLabs {
   // public static final String USERNAME = "sso-saleforce-sortuno";
   // public static final String ACCESS_KEY = "71f97d9a-e6f9-40b4-93f6-69d8b59af14e";
    public static final String URL = "https://sso-saleforce-sortuno:71f97d9a-e6f9-40b4-93f6-69d8b59af14e@ondemand.saucelabs.com:443/wd/hub";

    public static void main(String[] args)throws Exception{
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform","Window10");
        caps.setCapability("version","10.0");
        caps.setCapability("screenResolution", "1024x768");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

        driver.get("https://saucelabs.com/test/guinea-pig");
        System.out.println("title of page is: " + driver.getTitle());

        driver.quit();
    }
}
