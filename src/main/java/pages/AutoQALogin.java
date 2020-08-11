package pages;

import config.SeleniumHandler;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import scraper.ElemsPaths;

public class AutoQALogin {

    private SeleniumHandler handler;

    public AutoQALogin(SeleniumHandler handler) {
        this.handler = handler;
    }

    @Step("Enter login")
    private void setLogin(String login) {
        try {
            handler.setTextToElement(ElemsPaths.LOGIN_FIELD, login + Keys.ENTER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Step("Enter password")
    private void setPassword(String password) {
        try {
            handler.setTextToElement(ElemsPaths.PASSWORD_FIELD, password + Keys.ENTER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Parameters({ "url" })
    @Step("Get start")
    public void loginToAutoQA(String url, String login, String password) {
        handler.openPage(url);
        System.out.println("open page: " + url);
        this.setLogin(login);
        handler.waitSomeTime(5000);
        this.setPassword(password);
        handler.waitSomeTime(10000);
    }
}
