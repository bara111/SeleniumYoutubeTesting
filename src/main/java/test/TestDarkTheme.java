package test;

import PageFactory.YoutubeHomePage;
import infrastructure.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestDarkTheme {
    WebDriverConfiguration webDriverConfiguration=new WebDriverConfiguration();
    YoutubeHomePage youtubeHomePage;
    WebDriver driver;
    String methodName="";
    @BeforeMethod
    public void before(Method method) {
        methodName=method.getName();
    }
    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        driver = webDriverConfiguration.setup(browser,methodName);
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
