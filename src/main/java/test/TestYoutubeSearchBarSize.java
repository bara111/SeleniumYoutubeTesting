package test;

import PageFactory.YoutubeHomePage;
import infrastructure.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestYoutubeSearchBarSize {
    YoutubeHomePage youtubeHomePage;
    WebDriver webDriver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        webDriver = WebDriverConfiguration.setup(browser);
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
