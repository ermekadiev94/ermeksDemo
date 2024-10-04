package basic_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ByIdDemo {

    @Test
    void byIdTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameInput = driver.findElement(By.id("userName"));
        fullNameInput.sendKeys("John Doe");

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("john.doe@gmail.com");

        WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
        currentAddressInput.sendKeys("Wall street 123");

        WebElement permanentAddressInput = driver.findElement(By.id("permanentAddress"));
        permanentAddressInput.sendKeys("Some street 123");

        WebElement submitBtn = driver.findElement(By.id("submit"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitBtn).perform();
        submitBtn.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String secondText = (String) js.executeScript(
                "return document.evaluate('(//p[@id=\"permanentAddress\"]/text())[2]', document, null, XPathResult.STRING_TYPE, null).stringValue;"
        );
        System.out.println(secondText);

        Thread.sleep(4000);
        driver.close();
        driver.quit();
    }
}
