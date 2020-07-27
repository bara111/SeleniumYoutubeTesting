package infrastructure;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WebDriverConfiguration {

    public WebDriver driver;
    public ATUTestRecorder recorder;
    private DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
    private Date date = new Date();
    private String timeOfTheDay=dateFormat.format(date);
    private String basePath = "src\\testVideos\\";
    private String filePath;
    private String extensionName=".mov";
    public WebDriver setup(String browser,String fileName) {
        if (browser.equalsIgnoreCase("firefox")) {
            this.filePath = fileName+timeOfTheDay ;
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            System.setProperty("webdriver.gecko.driver", "src\\geckodriver.exe");
            try {
                recorder = new ATUTestRecorder(basePath, filePath, false);
                recorder.start();
            } catch (ATUTestRecorderException e) {
                e.printStackTrace();
            }
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("chrome")) {
            this.filePath = fileName+timeOfTheDay;
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");
            try {
                recorder = new ATUTestRecorder(basePath, filePath, false);
                recorder.start();
            } catch (ATUTestRecorderException e) {
                e.printStackTrace();
            }
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "src\\MicrosoftWebDriver.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public void deleteVideo() {
        File file = new File(basePath + filePath + extensionName);
        file.delete();
    }
}
