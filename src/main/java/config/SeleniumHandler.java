package config;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;


public class SeleniumHandler {

    private static final String SELENIUM_SERVER_URL = "http://localhost:4444/wd/hub";
    private static final int WAIT_TIME_MAX = 6;

    private WebDriver driver;
    private Wait<WebDriver> wait;

    public boolean start(boolean headlessMode, boolean needRemote) {
        try {
            driver = needRemote ? getRemoteDriver(headlessMode) : getChromeDriver(headlessMode);
            wait = new WebDriverWait(driver,WAIT_TIME_MAX);
        }catch (Exception e) {
            System.out.println("Error: driver was not initialized " + e.getMessage());
            return false;
        }
        return true;
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

    private WebDriver getChromeDriver(boolean headlessMode) {
        CromeConfig.setDriverPath();
        return new ChromeDriver(CromeConfig.getChromeOptions(headlessMode));
    }

    private WebDriver getRemoteDriver(boolean headlessMode) throws MalformedURLException {
        return new RemoteWebDriver(
                new URL(SELENIUM_SERVER_URL),
                CromeConfig.getDesiredCapabilities(headlessMode));
    }

    public WebElement getElem(String xpath) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public WebElement getChildElem(String xpath, WebElement parentElement) {
        return wait.until(
                ExpectedConditions.presenceOfNestedElementLocatedBy(parentElement,By.xpath(xpath))
        );
    }

    public String getChildElemText(String xpath, WebElement parentElement) {
        try {
            return getChildElem(xpath,parentElement).getText();
        } catch (Exception e) {
            System.out.println("Child element not located : " + e.getMessage());
            return "";
        }
    }

    public void click(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);arguments[0].click()",
                webElement
        );
    }

    public void waitSomeTime(int milliSec) {
        try {
            Thread.sleep(milliSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }


}
