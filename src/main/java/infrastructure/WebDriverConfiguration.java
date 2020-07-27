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
    private final String BASE_PATH = "src\\testVideos\\";
    private final DateFormat DATE_FORMAT = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
    private final Date date = new Date();
    private final String CURRENT_TIME_DATE = DATE_FORMAT.format(date);

    public WebDriver driver;
    public ATUTestRecorder recorder;
    private String filePath;
    public WebDriver setup(String browser,String fileName) {
        if (browser.equalsIgnoreCase("firefox")) {
            this.filePath = fileName+ CURRENT_TIME_DATE;
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            System.setProperty("webdriver.gecko.driver", "src\\geckodriver.exe");
            try {
                recorder = new ATUTestRecorder(BASE_PATH, filePath, false);
                recorder.start();
            } catch (ATUTestRecorderException e) {
                e.printStackTrace();
            }
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("chrome")) {
            this.filePath = fileName+ CURRENT_TIME_DATE;
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");
            try {
                recorder = new ATUTestRecorder(BASE_PATH, filePath, false);
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
        String EXTENSION_NAME = ".mov";
        File file = new File(BASE_PATH + filePath + EXTENSION_NAME);
        file.delete();
    }
}
