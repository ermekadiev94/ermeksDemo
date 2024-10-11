package demoqa.helper;

import demoqa.drivers.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementActions {

    Actions actions = new Actions(DriverManager.getDriver());

    public WebElementActions click(WebElement element) {
        waitElementToBeVisible(element);
        waitElementToBeClickable(element);
        highlight(element);
        element.click();
        return this;
    }

    public WebElementActions jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", element);
        return this;
    }

    public WebElementActions highlight(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)DriverManager.getDriver();
        executor.executeScript("arguments[0].style.border='3px solid yellow'", element);
        return this;
    }

    public WebElementActions input(WebElement element, String txt) {
        waitElementToBeVisible(element);
        highlight(element);
        element.sendKeys(txt);
        return this;
    }

    public WebElementActions navigateToElement(WebElement element) {
        actions.moveToElement(element).build().perform();
        return this;
    }

    public WebElementActions scrollToElement(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public WebElementActions waitElementToBeVisible(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions waitElementToBeClickable(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public String getTextFromElement(WebElement element) {
        waitElementToBeVisible(element);
        return element.getText();
    }

    public WebElementActions doubleClick(WebElement element) {
        waitElementToBeClickable(element);
        actions.doubleClick(element).build().perform();
        return this;
    }

    public WebElementActions rightClick(WebElement element) {
        waitElementToBeClickable(element);
        actions.contextClick(element).build().perform();
        return this;
    }
}
