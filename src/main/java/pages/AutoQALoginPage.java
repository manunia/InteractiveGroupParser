package pages;

import config.SeleniumHandler;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;

public class AutoQALoginPage {

    private static final String LOGIN_FIELD = "//*[@id='identifierId']";
    private static final String PASSWORD_FIELD = "//*[@id='password']/div[1]/div/div[1]/input";

    private SeleniumHandler handler;

    public AutoQALoginPage(SeleniumHandler handler) {
        this.handler = handler;
    }

    @Parameters({"login"})
    @Step("Enter login")
    private void setLogin(String login) {
        handler.setTextToElement(LOGIN_FIELD, login + Keys.ENTER);
    }

    @Parameters({"password"})
    @Step("Enter password")
    private void setPassword(String password) {
        handler.setTextToElement(PASSWORD_FIELD, password + Keys.ENTER);
    }

    @Parameters({"url"})
    @Step("Get start")
    public void loginToAutoQA(String login, String password) {
        this.setLogin(login);
        this.setPassword(password);
    }
}
