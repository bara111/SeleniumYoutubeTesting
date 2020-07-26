
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SimpleTest {
    @DataProvider(name = "AuthUsersInformation")
    public Object[][] createUserAccount() {
        return new Object[][]{
                {"am.bara059@gmail.com", "1234Moaz"},
        };
    }


    @Test(dataProvider = "AuthUsersInformation")
    public void checkAuthUser(String email,String password) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\BaraA\\Desktop\\chromedriver_win32\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://watanimall.com/customer/account/login/");
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        webDriver.findElement(By.cssSelector("input[id=email][type=email]")).click();
        webDriver.findElement(By.cssSelector("input[id=email][type=email]")).sendKeys(email);
        webDriver.findElement(By.cssSelector("input[id=pass][type=password]")).click();
        webDriver.findElement(By.cssSelector("input[id=pass][type=password]")).sendKeys(password);
        webDriver.findElement(By.cssSelector(".action.login.primary.mdl-button.mdl-js-button.mdl-button--raised.mdl-js-ripple-effect")).click();
        String expectedEmail=webDriver.findElement(By.cssSelector(".box-content p")).getText();
        Assert.assertTrue(expectedEmail.contains(email));
        webDriver.findElement(By.cssSelector("a.account-trigger.cdz-dd-trigger.cdz-top-link")).click();
        webDriver.findElement(By.cssSelector("div.cdz-dropdown.account-wrapper")).click();
        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
}
