package pages;

import config.SeleniumHandler;
import io.qameta.allure.Step;
import model.Mail;
import org.openqa.selenium.WebElement;

public class AutoQAMailPage {

    public static final String INCOMING_LETTERS = "//*[@data-tooltip='Входящие']";
    public static final String LETTERS = "//*[@class='bsU']";//т.к. мы находим дочерний элемент из блока входящих, то можно искать по классу

    public static final String NEW_LETTER = "//*[@class='aic']/div/div";

    public static final String ADRESS_FIELD = "//*[@name='to']";
    public static final String THEME_FIELD = "//*[@name='subjectbox']";
    public static final String LETTER_BODY = "//*[@class='Ar Au']/div[@aria-label='Тело письма']";
    public static final String SEND_BUTTON = "//*[@class='dC']/div";

    private SeleniumHandler handler;

    public AutoQAMailPage(SeleniumHandler handler) {
        this.handler = handler;
    }

    @Step("Count incoming letters")
    public String getResultFromIncomingLetters() {
        WebElement mail = handler.getElem(INCOMING_LETTERS);
        Mail result = getElementIncomingLetters(mail);
        System.out.println(result.toString());
        return result.toString();
    }

    private Mail getElementIncomingLetters(WebElement mail) {
        Mail mailObj = new Mail();

        mailObj.setCountLetters(handler.getChildElemText(LETTERS, mail));
        return mailObj;
    }

    @Step("Letter sending")
    private void sendLetter() {
        handler.click(handler.getElem(SEND_BUTTON));
    }

    @Step("Print letter body")
    private void setLetterBody(String s) {
        handler.setTextToElement(LETTER_BODY, s);
    }

    @Step("Enter theme")
    private void setTheme(String theme) {
        handler.setTextToElement(THEME_FIELD, theme);
    }

    @Step("Enter adress")
    private void setAdress(String adress) {
        handler.setTextToElement(ADRESS_FIELD, adress);
    }

    @Step("Press New letter button")
    private void createNewLetter() {
        handler.click(handler.getElem(NEW_LETTER));
    }

    public void createAndSendQALetter(String adress, String theme) {
        String letterBody = getResultFromIncomingLetters();
        createNewLetter();
        setAdress(adress);
        setTheme(theme);
        setLetterBody(letterBody);
        sendLetter();
    }
}
