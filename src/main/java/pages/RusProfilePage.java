package pages;

import config.SeleniumHandler;
import io.qameta.allure.Step;

public class RusProfilePage {
    private static final String OKVED_LIST = "//*[@id='wrapper']/section[6]/div/div[2]/div[1]/div";
    private static final String OKVED_KODE = "//*[@href='/codes/";

    private SeleniumHandler handler;

    public RusProfilePage(SeleniumHandler handler) {
        this.handler = handler;
    }

    @Step("Find okved list")
    private void findOkvedList() {
        handler.click(handler.getElem(OKVED_LIST));
    }

    @Step("Find okved code {0}")
    private void setPassword(int code) {
        handler.click(handler.getElem(OKVED_KODE + code + "0000']"));
    }

    @Step("Get start")
    public void findAllCompanies(int code) {
        this.findOkvedList();
        this.setPassword(code);
    }
}
