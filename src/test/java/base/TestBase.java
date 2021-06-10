package base;

import handlers.BrowserHandler;
import handlers.InitConfigHandler;
import handlers.WebDriverHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static HashMap<String, String> environmentConfigProperties;


    @BeforeSuite
    public void setUp() throws IOException {

        HashMap <String, String> initialProperties = InitConfigHandler.getInitialConfigProperties();
        InitConfigHandler.checkAndValidatedOS();

        // Initialize webdriver
        switch (initialProperties.get("browserName")){

            case "chrome": {
                System.setProperty("webdriver.chrome.driver", WebDriverHandler.getChromeDriverPath(initialProperties.get("os")));
                driver = new ChromeDriver(BrowserHandler.createChromeOptions());
                break;
            }
            case "firefox":{
                System.setProperty("webdriver.gecko.driver", WebDriverHandler.getFirefoxDriverPath(initialProperties.get("os")));
                driver = new FirefoxDriver(BrowserHandler.createFirefoxOptions());
                break;
            }
        }

        //Choose correct environment
        environmentConfigProperties = InitConfigHandler.loadEnvironmentConfigurationFile();

        //Load URL from correct environment configuration files
        driver.get(environmentConfigProperties.get("url"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

    }

    @AfterSuite
    public void cleanUp(){
        driver.quit();
    }
}
