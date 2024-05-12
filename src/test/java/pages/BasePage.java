package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        this.softAssert = new SoftAssert();

    }

    public WebDriverWait getDriverWait() {
        return wait;
    }

    protected void waitToBeClickable(WebElement element) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitToBeVisible(WebElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void clickOnElement(WebElement element) {
        this.waitToBeClickable(element);
        element.click();
    }
    protected void clickOnEnter(WebElement element) {
        this.waitToBeClickable(element);
        element.sendKeys(Keys.ENTER);
    }

    protected void sendKeysOnElement(WebElement element, String keys) {
        element.sendKeys(keys);
    }

    protected String getTextFromElement(WebElement element) {
        this.waitToBeVisible(element);
        return element.getText();
    }

    protected WebElement searchWebElementText(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase(text)) return element;
        }
        return null;
    }

    public void close() {
        this.driver.close();
    }

//    protected WebDriver getDriver() {
//        return this.driver;
//    }
}

