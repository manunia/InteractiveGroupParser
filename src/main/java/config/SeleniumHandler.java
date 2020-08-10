package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumHandler {

    private WebDriver driver;

    public boolean start(boolean headlessMode) {
        try {
            driver = getChromeDriver(headlessMode);
        }catch (Exception e) {
            System.out.println("Error: driver was not initialized " + e.getMessage());
            return false;
        }


        return true;

    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }

    }

    private WebDriver getChromeDriver(boolean headlessMode) {
        CromeConfig.setDriverPath();
        return new ChromeDriver(CromeConfig.getChromeOptions(headlessMode));
    }

    public boolean openPage(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            System.out.println("Error opening page: "+ url);
            return false;
        }


        return true;
    }

}
