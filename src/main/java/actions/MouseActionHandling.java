package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseActionHandling {

    private final Actions mouseActions;
    private final WebDriverWait wait;

    public MouseActionHandling(WebDriver webDriver) {
        mouseActions = new Actions(webDriver);
        wait = new WebDriverWait(webDriver, 30);

    }

    public void click(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        mouseActions.click(webElement).perform();
    }

    public void doubleClick(WebElement webElement) {
        mouseActions.doubleClick(webElement).perform();
    }

    public void contextClick(WebElement webElement) {
        mouseActions.contextClick(webElement).perform();
    }

    public void clickAndHold(WebElement webElement) {
        mouseActions.clickAndHold(webElement).perform();
    }

    public void dragAndDropBy(WebElement webElement, int xOffset, int yOffset) {
        mouseActions.dragAndDropBy(webElement, xOffset, yOffset).perform();
    }

    public void moveByOffset(int xOffset, int yOffset) {
        mouseActions.moveByOffset(xOffset, yOffset).perform();
    }

    public void moveToElement(WebElement webElement) {
        mouseActions.moveToElement(webElement).perform();
    }

    public void release(WebElement webElement) {
        mouseActions.release(webElement).perform();
    }
}
