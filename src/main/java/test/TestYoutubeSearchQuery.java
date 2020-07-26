package test;

import PageFactory.YoutubeHomePage;
import infrastructure.WebDriverConfiguration;
import infrastructure.YoutubeSearchQueryDataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import util.Converters;

import java.util.concurrent.TimeUnit;

public class TestYoutubeSearchQuery {

    YoutubeHomePage youtubeHomePage;
    WebDriver driver;
    String browser;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        this.browser = browser;
        driver = WebDriverConfiguration.setup(browser);
        youtubeHomePage = new YoutubeHomePage(driver);
        driver.get(YoutubeHomePage.URL);

    }

    @BeforeMethod
    public void before() {
        youtubeHomePage.clearSearchFiled();
    }

    @Test(dataProvider = "youtubeSearchQueryProvider", dataProviderClass = YoutubeSearchQueryDataProvider.class)
    public void testYoutubeSearchQuery(String run, String expectedQuery)  {
        youtubeHomePage.searchYoutubeHomePage(expectedQuery);
        youtubeHomePage.waitForProgressBar();
        String[] url = driver.getCurrentUrl().split("=");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        Assert.assertEquals(Converters.convertQueryToString(url), expectedQuery);
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
