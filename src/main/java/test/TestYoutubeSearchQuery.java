package test;

import PageFactory.YoutubeHomePage;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import infrastructure.WebDriverConfiguration;
import infrastructure.YoutubeSearchQueryDataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;
import util.DataUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestYoutubeSearchQuery {
    WebDriverConfiguration webDriverConfiguration;
    YoutubeHomePage youtubeHomePage;
    WebDriver driver;
    String browser;
    Boolean deleteFile=true;
    String methodName="";

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        this.browser = browser;
        webDriverConfiguration =new WebDriverConfiguration();
         methodName = getClass().getSimpleName();

        driver = webDriverConfiguration.setup(browser,methodName);
        youtubeHomePage = new YoutubeHomePage(driver);
        driver.get(YoutubeHomePage.URL);
    }

    @BeforeMethod
    public void before(Method method) {
        youtubeHomePage.clearSearchFiled();
    }

    @Test(dataProvider = "youtubeSearchQueryProvider", dataProviderClass = YoutubeSearchQueryDataProvider.class)
    public void testYoutubeSearchQuery(String run, String expectedQuery)  {
        if(expectedQuery.contains("react"))
            throw new SkipException("skipped");
        youtubeHomePage.searchYoutubeHomePage(expectedQuery);
        youtubeHomePage.waitForProgressBar();
        String[] url = driver.getCurrentUrl().split("=");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        Assert.assertEquals(DataUtils.convertQueryToString(url), expectedQuery,"");
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            deleteFile=false;
        }
    }
    @AfterTest
    public void afterTest() {
        driver.close();
        try {
            webDriverConfiguration.recorder.stop();
        } catch (ATUTestRecorderException e) {
            e.printStackTrace();
        }
        if(deleteFile){
            webDriverConfiguration.deleteVideo();
        }
    }
}
