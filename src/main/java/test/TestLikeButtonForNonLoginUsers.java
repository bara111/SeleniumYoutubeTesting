package test;

import PageFactory.YoutubeHomePage;
import PageFactory.YoutubeVideoPage;
import infrastructure.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLikeButtonForNonLoginUsers {
    YoutubeVideoPage youtubeVideoPage;
    WebDriver webDriver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        webDriver = WebDriverConfiguration.setup(browser);
        youtubeVideoPage = new YoutubeVideoPage(webDriver,"/watch?v=wtg7AetxuWo");
        webDriver.get(YoutubeHomePage.URL);
    }

    @Test
    @Parameters("browser")
    public void testLikeButtonForNonLoginUsers(String browser) {
        webDriver=WebDriverConfiguration.setup(browser);
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
