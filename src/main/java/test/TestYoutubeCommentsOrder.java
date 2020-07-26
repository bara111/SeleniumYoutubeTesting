package test;

import PageFactory.YoutubeVideoPage;
import infrastructure.WebDriverConfiguration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestYoutubeCommentsOrder {
    YoutubeVideoPage youtubeVideoPage;
    WebDriver webDriver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        webDriver = WebDriverConfiguration.setup(browser);
        youtubeVideoPage = new YoutubeVideoPage(webDriver, "/watch?v=l9nh1l8ZIJQ");
        webDriver.get(youtubeVideoPage.URL);

    }

    @Test
    public void testYoutubeMenuIcon() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,400)");
        youtubeVideoPage.clickSortBy();
        youtubeVideoPage.clickNewestCommentOption();
        youtubeVideoPage.waitForCommentsProgressToHidden();
        youtubeVideoPage.getCommentsTime(5);
        Assert.assertTrue(youtubeVideoPage.checkSoringComments());
    }

    @AfterTest
    public void afterTest() {
       webDriver.close();
    }

}
