package test;

import PageFactory.YoutubeHomePage;
import infrastructure.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestYoutubeSearchBarSize {
    WebDriverConfiguration webDriverConfiguration=new WebDriverConfiguration();

    YoutubeHomePage youtubeHomePage;
    WebDriver webDriver;
    String methodName="";

    @BeforeMethod
    public void before(Method method) {
        methodName=method.getName();
    }

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        webDriver = webDriverConfiguration.setup(browser,methodName);
        youtubeHomePage = new YoutubeHomePage(webDriver);
        webDriver.get(YoutubeHomePage.URL);
    }

    @Test
    public void testYoutubeSearchBarSize() {
        Assert.assertTrue(youtubeHomePage.toolTipHasDisableUpgrade());
        youtubeHomePage.clickSearchButtonForSmallWindow();
        Assert.assertFalse(youtubeHomePage.toolTipHasDisableUpgrade());
        youtubeHomePage.clickArrowBackIcon();
        Assert.assertTrue(youtubeHomePage.toolTipHasDisableUpgrade());
    }

    @AfterTest
    public void AfterTest() {
        webDriver.quit();
    }
}
