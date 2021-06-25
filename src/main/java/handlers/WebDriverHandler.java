package handlers;

import java.io.File;

public class WebDriverHandler {

    //Path to webDriver folder where web drivers are stored
    public static final String WINDOWS_CHROME_DRIVER_PATH = System.getProperty("user.dir") + File.separator + "webDrivers" + File.separator + "windows" + File.separator + "chromedriver.exe";
    public static final String WINDOWS_FIREFOX_DRIVER_PATH = System.getProperty("user.dir") + File.separator + "webDrivers" + File.separator + "windows" + File.separator + "geckodriver.exe";

    public static final String MAC_CHROME_DRIVER_PATH = System.getProperty("user.dir") + File.separator + "webDrivers" + File.separator + "mac" + File.separator + "chromedriver";

    public static String getChromeDriverPath(String os){
        String chromeDriverPath = "";
        switch (os){
            case "windows": chromeDriverPath = WINDOWS_CHROME_DRIVER_PATH;
            break;
            case "mac": chromeDriverPath = MAC_CHROME_DRIVER_PATH;
            break;
        }
        return chromeDriverPath;
    }

    public static String getFirefoxDriverPath(String os){
        String firefoxDriverPath = "";
        if (os.equals("windows")) {
            firefoxDriverPath = WINDOWS_FIREFOX_DRIVER_PATH;
        }
        return firefoxDriverPath;
    }
}
