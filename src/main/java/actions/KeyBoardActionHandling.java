package actions;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyBoardActionHandling {
    private final Actions keyboardActions;
    private final WebDriverWait wait;

    public KeyBoardActionHandling(WebDriver webDriver) {
        keyboardActions = new Actions(webDriver);
         wait = new WebDriverWait(webDriver, 15);
    }

    public void setKey(WebElement webElement, String text) {
        clear(webElement);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        keyboardActions.sendKeys(webElement, text).perform();
    }

    public void clear(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public void keyDown(String key) {
        keyboardActions.keyDown(key).perform();
    }
}
