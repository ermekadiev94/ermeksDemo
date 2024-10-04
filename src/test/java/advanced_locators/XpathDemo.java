package advanced_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class XpathDemo {

    @Test
    void absoluteXpathDemoTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[5]/div/button"));
    }

    @Test
    void relativeXpathDemoTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submit']"));
        WebElement submitBtn1 = driver.findElement(By.xpath("//button[@type='button' and text()='Submit']"));
        WebElement submitBtn2 = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        //input[@placeholder='Full Name']
        //input[@placeholder='Full Name' and @type='text' or @id='userName']
        //*[@placeholder='Full Name']
        //div[@id='output']/div/p[@id='currentAddress']
        //p[@id='currentAddress']/..
        //h1[text()='Text Box']
        //h1[contains(text(),'Text')]
        //h3[contains(text(),'Фаиза / Faiza')]
        //h3[normalize-space()='Фаиза / Faiza']
        //span[starts-with(text(),'Перед')]
        //input[starts-with(@id,'userE')]
        //div[@id='brandsRefinements']/ul[1]/span/span[position()=3]
        //div[@id='brandsRefinements']/ul[1]/span/span[position()=4]
        //div[@id='brandsRefinements']/ul[1]/span/span[last()]
        //999.99     //span[round(text())='999] ---> 1000
        //999.99     //span[floor(text())='999] ---> 999
        //input[starts-with(@id,'user') and not(@type='text') ]
    }
    //div[@id='brandsRefinements']/ul/span/span/li/span/a/span


    //XPath Axes
    //1. parent --> //div[@id='brandsRefinements']/ul/span/span/parent::span or /..
    //2. child --> //div[@id='brandsRefinements']/ul[position()=1]/span/child::span
    //3. ancestor --> //span[text()='Apple' and @class='a-size-base a-color-base']/ancestor::ul
    //4. descendant  ---> //div[@id='brandsRefinements']/descendant::span
    //5. following-sibling ---> //div[@id='brandsRefinements']/ul/span/span/following-sibling::span[5]
    ////div[@id='brandsRefinements']/ul[position()=1]/span/span[1]/following-sibling::span[4]
    //6. preceding ---> //tbody/tr[2]/td[3]/preceding-sibling::td[2]

    @Test
    void amazonXpathDemoTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone"+ Keys.ENTER);
        Thread.sleep(5000);

        List<WebElement> brands = driver.findElements(By.xpath(" //div[@id='brandsRefinements']/ul/span/span/li/span/a/span"));

        for (WebElement brand : brands) {
            System.out.println(brand.getText());
        }
        driver.close();
    }
}
