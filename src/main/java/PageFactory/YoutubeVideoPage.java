package PageFactory;

import actions.KeyBoardActionHandling;
import actions.MouseActionHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.DataUtils;
import util.AttributeUtils;

import java.util.ArrayList;

public class YoutubeVideoPage {
    public  String URL = "https://www.youtube.com";
    WebDriver webDriver;
    ArrayList<String> commentsListTimeText;
    ArrayList<Double> commentsListTimeInDays;

    MouseActionHandling mouseActionHandling;
    KeyBoardActionHandling keyBoardActionHandling;
    String hiddenAttribute = "aria-hidden";
    @FindBy(css = "button[aria-label^=like]")
    WebElement likeButton;
    @FindBy(css = "style-scope ytd-popup-container")
    WebElement popUpContainer;
    @FindBy(css = "paper-menu-button")
    WebElement sortByMenu;
    @FindBy(css = "paper-listbox#menu a:nth-child(2)")
    WebElement newestCommentsOption;
    @FindBy(css = "#spinner-container paper-spinner-lite.ytd-item-section-renderer")
    WebElement progressBar;

    public YoutubeVideoPage(WebDriver webDriver, String videoPath) {
        this.URL += videoPath;
        this.webDriver = webDriver;
        this.mouseActionHandling = new MouseActionHandling(webDriver);
        this.keyBoardActionHandling = new KeyBoardActionHandling(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    public void clickLikeButton() {
        this.mouseActionHandling.click(likeButton);
    }


    public Boolean popUpContainerHasFocusedAttribute() {
        return AttributeUtils.isAttributeHidden(popUpContainer, hiddenAttribute);
    }

    public void clickSortBy() {
        this.mouseActionHandling.click(sortByMenu);
    }

    public void clickNewestCommentOption() {
        this.mouseActionHandling.click(newestCommentsOption);
    }

    public void waitForCommentsProgressToHidden() {
        AttributeUtils.waitForCommentsProgressToHidden(webDriver, progressBar, hiddenAttribute);
    }

    public void getCommentsTime(int numberOfComments) {
        commentsListTimeText = new ArrayList<>();
        for (int i = 1; i < numberOfComments + 1; i++) {
            WebElement element = webDriver.findElement(By.cssSelector("ytd-comment-thread-renderer:nth-child(+" + i + ") yt-formatted-string a"));
            commentsListTimeText.add(element.getText());
        }
    }

    public boolean checkSoringComments() {
        commentsListTimeInDays = DataUtils.convertListOfStringToDoubleTimeUnit(commentsListTimeText);
        return DataUtils.isSorted(commentsListTimeInDays);
    }
}
