package handlers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;

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
        FirefoxProfile profile = new FirefoxProfile();
        return profile;
    }
}
