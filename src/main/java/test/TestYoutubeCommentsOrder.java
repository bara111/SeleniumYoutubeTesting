package test;

import PageFactory.YoutubeVideoPage;
import infrastructure.WebDriverConfiguration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestYoutubeCommentsOrder {
    WebDriverConfiguration webDriverConfiguration=new WebDriverConfiguration();
    YoutubeVideoPage youtubeVideoPage;
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
