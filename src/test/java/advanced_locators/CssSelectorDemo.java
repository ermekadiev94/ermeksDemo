package advanced_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class CssSelectorDemo {

    @Test
    void cssSelectorDemoTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement submitBtn = driver.findElement(By.cssSelector(".w3-example"));
        WebElement submitBtn1 = driver.findElement(By.cssSelector("#userName"));
        //#userName
        // css selector --->  input[type='text']
        //table[id='customers'] tbody tr th:nth-child(3)
        //span[class^='color'] --> startsWith
        //span[class$='_h1']  --> endWith
        //span[class*='_h1'] --> contains
        //table[id='customers'] > tbody > tr > th
        //table[id='customers'] tr
        //div[id='userName-wrapper'] + div + div + div + div+ div
    }
}
