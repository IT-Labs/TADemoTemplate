package base;

import handlers.BrowserHandler;
import handlers.InitConfigHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static handlers.WebDriverHandler.getWebDriverPath;

public class TestBase {
    public static WebDriver driver;
    public static HashMap<String, String> environmentConfigProperties;


    @BeforeSuite
    public void setUp() throws IOException {

        HashMap <String, String> localConfigProperties = InitConfigHandler.getInitialConfigProperties();

        //Find correct driver - set webdriver path to initialize the driver
        String webDriverPath = getWebDriverPath(System.getProperty("os"), System.getProperty("browserName"));

        // Initialize webdriver
        /*switch (localConfigProperties.get("browserName")){

            case "chrome": {
                System.setProperty("webdriver.chrome.driver", webDriverPath);
                driver = new ChromeDriver(BrowserHandler.createChromeOptions());
                break;
            }
            case "firefox":{
                System.setProperty("webdriver.gecko.driver", webDriverPath);
                driver = new FirefoxDriver(BrowserHandler.createFirefoxOptions());
                break;
            }
        }*/

        switch (localConfigProperties.get("os").toLowerCase()){

            case "windows": {
                if(localConfigProperties.get("browserName").toLowerCase().equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", webDriverPath);
                    driver = new ChromeDriver(BrowserHandler.createChromeOptions());
                }
                else if(localConfigProperties.get("browserName").toLowerCase().equals("firefox")){
                    System.setProperty("webdriver.gecko.driver", webDriverPath);
                    driver = new FirefoxDriver(BrowserHandler.createFirefoxOptions());
                }
                break;
            }
            case "mac":{
                System.setProperty("webdriver.chrome.driver", webDriverPath);
                driver = new ChromeDriver(BrowserHandler.createFirefoxOptions());
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
