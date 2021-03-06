package base;

import handlers.BrowserHandler;
import handlers.InitConfigHandler;
import handlers.WebDriverHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static HashMap<String, String> environmentConfigProperties;


    @BeforeSuite
    public void setUp() {

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
            case "safari":{
                driver = new SafariDriver();
                break;
            }
            case "edge": {
                System.setProperty("webdriver.edge.driver", WebDriverHandler.getEdgeDriverPath(initialProperties.get("os")));
                driver = new EdgeDriver(BrowserHandler.createEgdeOptions());
                break;
            }
        }

        //Choose correct environment
        environmentConfigProperties = InitConfigHandler.loadEnvironmentConfigurationFile();

        //Load URL from correct environment configuration files
        driver.get(environmentConfigProperties.get("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void cleanUp(){
        driver.quit();
    }
}
