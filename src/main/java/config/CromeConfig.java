package config;

import org.openqa.selenium.chrome.ChromeOptions;

public class CromeConfig {

    private static final String CHROME_DRIVER_PATH = "src/main/resources/chromedriver.exe";

    static void setDriverPath() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

    }

    static ChromeOptions getChromeOptions(boolean headlessMode) {
        ChromeOptions options = new ChromeOptions()
                .addArguments("--lang=ru")
                .addArguments("start-maximized")
                .addArguments("--whitelisted-ips");
        if (headlessMode) {
            options.addArguments("--headless");
        }
        return options;
    }
}
