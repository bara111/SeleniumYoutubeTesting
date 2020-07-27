package test;

import PageFactory.YoutubeHomePage;
import PageFactory.YoutubeVideoPage;
import infrastructure.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestLikeButtonForNonLoginUsers {
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
        youtubeVideoPage = new YoutubeVideoPage(webDriver,"/watch?v=wtg7AetxuWo");
        webDriver.get(YoutubeHomePage.URL);
    }

    @Test
    @Parameters("browser")
    public void testLikeButtonForNonLoginUsers(String browser) {
        webDriver = webDriverConfiguration.setup(browser,methodName);
        youtubeVideoPage=new YoutubeVideoPage(webDriver,"/watch?v=wAPCSnAhhC8");
        webDriver.get(youtubeVideoPage.URL);
        youtubeVideoPage.clickLikeButton();
        Assert.assertFalse(youtubeVideoPage.popUpContainerHasFocusedAttribute());
    }
    @AfterTest
    public void afterTest() {
        webDriver.close();
    }
}
