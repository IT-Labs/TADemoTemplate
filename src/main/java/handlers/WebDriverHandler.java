package handlers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebDriverHandler {

    //Path to webDriver folder where web drivers are stored
    public static final String WINDOWS_CHROME_DRIVER_PATH = System.getProperty("user.dir") + File.separator + "webDrivers" + File.separator + "windows" + File.separator + "chromedriver.exe";
    public static final String WINDOWS_FIREFOX_DRIVER_PATH = System.getProperty("user.dir") + File.separator + "webDrivers" + File.separator + "windows" + File.separator + "geckodriver.exe";



    public static String setWebDriverPath(String operatingSystem, String browserName){
        // TODO: 5/21/2021  Better handling driver path initialization and error handling
        String driverPath = "";
        if(System.getProperty("os.name").toLowerCase().contains("windows") && operatingSystem.toLowerCase().equals("windows")){
            switch (browserName.toLowerCase()){
                case "chrome":  driverPath = WINDOWS_CHROME_DRIVER_PATH;
                break;
                case "firefox":  driverPath = WINDOWS_FIREFOX_DRIVER_PATH;
                break;
            }
        }
        else if (operatingSystem.toLowerCase().equals("mac")){
//ToDo mac
        }
        return  driverPath;
    }


    public static WebDriver initializeWebDriver(WebDriver driver) throws IOException {

        switch (InitConfigHandler.initialPropertiesMap.get("browserName")){
            case "chrome": {
                //HelperMethods.createChromeOptions();
                System.setProperty("webdriver.chrome.driver", setWebDriverPath(InitConfigHandler.initialPropertiesMap.get("os"), InitConfigHandler.initialPropertiesMap.get("os")));
                driver = new ChromeDriver(BrowserHandler.createChromeOptions());
            }
            case "firefox":{
                System.setProperty("webdriver.gecko.driver", setWebDriverPath(InitConfigHandler.initialPropertiesMap.get("os"), InitConfigHandler.initialPropertiesMap.get("os")));
                driver = new FirefoxDriver(BrowserHandler.createFirefoxOptions());
            }
        }

        driver.get(InitConfigHandler.loadEnvironmentConfigurationFile().get("url").toString());///Not clear
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

        return driver;
    }
}
