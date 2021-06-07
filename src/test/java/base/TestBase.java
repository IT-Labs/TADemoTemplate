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

import static handlers.WebDriverHandler.setWebDriverPath;

public class TestBase {
    public WebDriver driver;
    public static HashMap<String, String> loadedConfigProperties;


    @BeforeSuite
    public void setUp() throws IOException {
        //Loaded properties from environment configuration files
        loadedConfigProperties = InitConfigHandler.loadEnvironmentConfigurationFile();

        //start correct driver - set webdriver path
        String webDriverPath = setWebDriverPath(System.getProperty("os"), System.getProperty("browserName"));

        // Initialize browser
        switch (InitConfigHandler.getInitialConfigProperties().get("browserName")){
            case "chrome": {
                //HelperMethods.createChromeOptions();
                System.setProperty("webdriver.chrome.driver", setWebDriverPath(InitConfigHandler.getInitialConfigProperties().get("os"), InitConfigHandler.getInitialConfigProperties().get("browserName")));
                driver = new ChromeDriver(BrowserHandler.createChromeOptions());
                break;
            }
            case "firefox":{
                System.setProperty("webdriver.gecko.driver", setWebDriverPath(InitConfigHandler.getInitialConfigProperties().get("os"), InitConfigHandler.getInitialConfigProperties().get("browserName")));
                driver = new FirefoxDriver(BrowserHandler.createFirefoxOptions());
                break;
            }
        }

        driver.get(InitConfigHandler.loadEnvironmentConfigurationFile().get("url").toString());///Not clear
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

    }

    @AfterSuite
    public void cleanUp(){
        driver.quit();
    }
}
