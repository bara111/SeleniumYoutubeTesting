package infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverConfiguration {

    public static WebDriver driver;
    
    public static WebDriver setup(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            System.setProperty("webdriver.gecko.driver", "src\\geckodriver.exe");
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "src\\MicrosoftWebDriver.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
