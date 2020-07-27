package test;

import PageFactory.YoutubeHomePage;
import infrastructure.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestYoutubeMenuIcon {
    WebDriverConfiguration webDriverConfiguration=new WebDriverConfiguration();
    YoutubeHomePage youtubeHomePage;
    WebDriver webDriver;
    String browser;
    String methodName="";

    @BeforeMethod
    public void before(Method method) {
        methodName=method.getName();
    }

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        this.browser = browser;
        webDriver = webDriverConfiguration.setup(browser,methodName);
        youtubeHomePage = new YoutubeHomePage(webDriver);
        webDriver.get(YoutubeHomePage.URL);
    }

    @Test
    public void testYoutubeMenuIcon() {
        Assert.assertTrue(youtubeHomePage.isDrawerOpened());
        youtubeHomePage.clickMenuIcon();
        Assert.assertFalse(youtubeHomePage.isDrawerOpened());
    }

    @AfterTest
    public void afterTest() {
        webDriver.close();
    }

}
