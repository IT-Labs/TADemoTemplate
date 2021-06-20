package handlers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BrowserHandler {

    public static ChromeOptions createChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-fullscreen");
        return chromeOptions;
    }

    public static FirefoxOptions createFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile profile = createFirefoxProfile();
        firefoxOptions.setProfile(profile);
        return firefoxOptions;
    }

    public static FirefoxProfile createFirefoxProfile() {
        return new FirefoxProfile();
    }

    public static EdgeOptions createEdgeOptions(){
        return new EdgeOptions();
    }
}
