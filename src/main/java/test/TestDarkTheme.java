package test;

import PageFactory.YoutubeHomePage;
import infrastructure.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDarkTheme {
    YoutubeHomePage youtubeHomePage;
    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        driver = WebDriverConfiguration.setup(browser);
        youtubeHomePage = new YoutubeHomePage(driver);
        driver.get(YoutubeHomePage.URL);
    }

    @Test
    public void testDarkTheme() {
        Assert.assertFalse(youtubeHomePage.toolDarkAttribute());
        youtubeHomePage.clickSettings();
        youtubeHomePage.clickDarkTheme();
        youtubeHomePage.clickDarkThemeToggleButton();
        Assert.assertTrue(youtubeHomePage.toolDarkAttribute());
        youtubeHomePage.clickDarkThemeToggleButton();
        Assert.assertFalse(youtubeHomePage.toolDarkAttribute());
    }
    @AfterTest
    public void afterTests(){
        driver.quit();
    }
}
