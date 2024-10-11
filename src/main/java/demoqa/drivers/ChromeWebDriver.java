package demoqa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

import static demoqa.utils.ConfigReader.getValue;

public class ChromeWebDriver {

    public static WebDriver loadFirefoxDriver() {
        // Set up the FirefoxDriver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();

        // Create FirefoxOptions to customize the browser settings
        FirefoxOptions options = new FirefoxOptions();

        // Enable headless mode if specified
        if (Boolean.parseBoolean(getValue("headless"))) {
            options.addArguments("--headless");
        }

        // Set the window size
        options.addArguments("--width=1920");
        options.addArguments("--height=1080");

        // Initialize the FirefoxDriver with the options
        WebDriver driver = new FirefoxDriver(options);

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Maximize the window if not in headless mode
        if (!Boolean.parseBoolean(getValue("headless"))) {
            driver.manage().window().maximize();
        }

        return driver;
    }
}
