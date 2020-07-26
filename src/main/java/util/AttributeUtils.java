package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AttributeUtils {

    public static Boolean isAttributeHidden(WebElement webElement, String attribute) {
        boolean result = false;
        try {
            String value = webElement.getAttribute(attribute);
            if (value != null) {
                result = true;
            }
        } catch (Exception ignored) {
        }
        return result;
    }
    public static void waitForCommentsProgressToHidden(WebDriver webDriver,WebElement webElement,String attribute) {
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until((ExpectedCondition<Boolean>) driver -> {
            boolean result = false;
            try {
                String value = webElement.getAttribute(attribute);
                if (value != null) {
                    result = true;
                }
            } catch (Exception ignored) {
            }

            return result;
        });
    }

}
