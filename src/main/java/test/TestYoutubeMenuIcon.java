package test;

import PageFactory.YoutubeHomePage;
import infrastructure.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestYoutubeMenuIcon {
    YoutubeHomePage youtubeHomePage;
    WebDriver webDriver;
    String browser;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        this.browser = browser;
        webDriver = WebDriverConfiguration.setup(browser);
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
