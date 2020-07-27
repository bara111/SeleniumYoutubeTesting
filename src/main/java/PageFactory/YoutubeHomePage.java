package PageFactory;

import actions.KeyBoardActionHandling;
import actions.MouseActionHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.AttributeUtils;

public class YoutubeHomePage {
    public static final String URL = "https://www.youtube.com/";
    private final WebDriver webDriver;
    private final MouseActionHandling mouseActionHandling;
    private final KeyBoardActionHandling keyBoardActionHandling;
    private final WebDriverWait wait;
    @FindBy(css = "input#search")
    WebElement youtubeSearchField;
    @FindBy(css = "#search-icon-legacy")
    WebElement youtubeSearchButton;
    @FindBy(id = "guide-icon")
    WebElement menuIcon;
    @FindBy(css = "div#contentContainer")
    WebElement appDrawersDiv;
    @FindBy(id = "search-button")
    WebElement searchButtonForSmallWindow;
    @FindBy(css = "#start #back-button")
    WebElement arrowBackIcon;
    @FindBy(id = "back-button-tooltip")
    WebElement tooltip;
    @FindBy(css = "#button[aria-label=Settings]")
    WebElement settingsIcon;
    @FindBy(css = "ytd-toggle-theme-compact-link-renderer")
    WebElement darkThemeButton;
    @FindBy(id = "toggleButton")
    WebElement darkThemeToggleButton;
    @FindBy(css = "html")
    WebElement htmlRoot;
    @FindBy(css="yt-page-navigation-progress")
    WebElement progressBar;


    public YoutubeHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.mouseActionHandling = new MouseActionHandling(webDriver);
        this.keyBoardActionHandling = new KeyBoardActionHandling(webDriver);
        wait = new WebDriverWait(webDriver, 20);
        PageFactory.initElements(this.webDriver, this);
    }

    public void setYoutubeSearchField(String query) {
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#search")));
        wait.until(ExpectedConditions.elementToBeClickable(youtubeSearchField));
        this.keyBoardActionHandling.setKey(youtubeSearchField, query);
    }

    public void clickYoutubeSearchButton() {
        this.mouseActionHandling.click(youtubeSearchButton);
    }

    public void searchYoutubeHomePage(String query) {
        this.setYoutubeSearchField(query);
        this.clickYoutubeSearchButton();
    }

    public void waitForProgressBar() {
        AttributeUtils.waitForCommentsProgressToHidden(webDriver,progressBar,"hidden");
    }

    public void clearSearchFiled() {
        String inputFieldSelector = "input#search";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(inputFieldSelector)));
        wait.until(ExpectedConditions.elementToBeClickable(youtubeSearchField));
        this.keyBoardActionHandling.clear(youtubeSearchField);
    }

    public void clickMenuIcon() {
        this.mouseActionHandling.click(menuIcon);
    }

    public void clickSearchButtonForSmallWindow() {
        this.mouseActionHandling.click(searchButtonForSmallWindow);
    }

    public void clickArrowBackIcon() {
        this.mouseActionHandling.click(arrowBackIcon);
    }

    public Boolean isDrawerOpened() {
        String openAttribute = "opened";
        return AttributeUtils.isAttributeHidden(appDrawersDiv, openAttribute);
    }

    public Boolean toolTipHasDisableUpgrade() {
        String disableUpgradeAttribute = "disable-upgrade";
        return AttributeUtils.isAttributeHidden(tooltip, disableUpgradeAttribute);
    }

    public Boolean toolDarkAttribute() {
        String darkAttribute = "dark";
        return AttributeUtils.isAttributeHidden(htmlRoot, darkAttribute);
    }


    public void clickSettings() {
        this.mouseActionHandling.click(settingsIcon);
    }

    public void clickDarkTheme() {
        this.mouseActionHandling.click(darkThemeButton);
    }

    public void clickDarkThemeToggleButton() {
        this.mouseActionHandling.click(darkThemeToggleButton);
    }
}















