package webdriver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSettings {

    public static WebDriver driver;

    //@Before
    public void driverInit() {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (System.getProperty("os.name").equals("Windows 10")) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            chromeOptions.addArguments("--headless");
        }
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-setuid-sandbox");
        //chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    //@After
    public void close() {
        driver.quit();
        System.out.println("Done!");
    }

}
