package pages;

import config.SeleniumHandler;
import io.qameta.allure.Step;
import model.Mail;
import org.testng.annotations.Parameters;

public class AutoQAMailPage {

    private static final String INCOMING_LETTERS = "//*[@class='TK']/div[@class='aim ain']";
    private static final String LETTERS = "//*[@class='bsU']";//т.к. мы находим дочерний элемент из блока входящих, то можно искать по классу

    private static final String NEW_LETTER = "//*[@class='aic']/div/div";

    private static final String ADRESS_FIELD = "//*[@name='to']";
    private static final String THEME_FIELD = "//*[@name='subjectbox']";
    private static final String LETTER_BODY = "//*[@class='Ar Au']/div[@aria-label='Тело письма']";
    private static final String SEND_BUTTON = "//*[@class='dC']/div";

    private SeleniumHandler handler;

    public AutoQAMailPage(SeleniumHandler handler) {
        this.handler = handler;
    }

    @Parameters({"result"})
    @Step("Count incoming letters")
    public String getResultFromIncomingLetters() {
        Mail result = getElementIncomingLetters(INCOMING_LETTERS);
        System.out.println(result.toString());
        return result.toString();
    }

    private Mail getElementIncomingLetters(String mail) {
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

    @Parameters({"theme"})
    @Step("Enter theme")
    private void setTheme(String theme) {
        handler.setTextToElement(THEME_FIELD, theme);
    }

    @Parameters({"addres"})
    @Step("Enter addres")
    private void setAddres(String addres) {
        handler.setTextToElement(ADRESS_FIELD, addres);
    }

    @Step("Press New letter button")
    private void createNewLetter() {
        handler.click(handler.getElem(NEW_LETTER));
    }

    public void createALetter(String adress, String theme) {
        String letterBody = getResultFromIncomingLetters();
        createNewLetter();
        setAddres(adress);
        setTheme(theme);
        setLetterBody(letterBody);
        sendLetter();
    }
}
