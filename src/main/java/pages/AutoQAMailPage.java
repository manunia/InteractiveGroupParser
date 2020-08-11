package pages;

import config.SeleniumHandler;
import io.qameta.allure.Step;
import model.Mail;
import org.openqa.selenium.WebElement;
import scraper.ElemsPaths;

public class AutoQAMailPage {

    private SeleniumHandler handler;

    public AutoQAMailPage(SeleniumHandler handler) {
        this.handler = handler;
    }

    @Step("Count incoming letters")
    public String getResultFromIncomingLetters() {
        WebElement mail = handler.getElem(ElemsPaths.INCOMING_LETTERS);
        Mail result = getElementIncomingLetters(mail);
        System.out.println(result.toString());
        return result.toString();
    }

    private Mail getElementIncomingLetters(WebElement mail) {
        Mail mailObj = new Mail();

        mailObj.setCountLetters(handler.getChildElemText(ElemsPaths.LETTERS, mail));
        return mailObj;
    }

    @Step("Letter sending")
    private void sendLetter() {
        try {
            handler.click(handler.getElem(ElemsPaths.SEND_BUTTON));
            System.out.println("Письмо отправлено");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Step("Print letter body")
    private void setLetterBody(String s) {
        try {
            handler.setTextToElement(ElemsPaths.LETTER_BODY, s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Step("Enter theme")
    private void setTheme(String theme) {
        try {
            handler.setTextToElement(ElemsPaths.THEME_FIELD, theme);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Step("Enter adress")
    private void setAdress(String adress) {
        try {
            handler.setTextToElement(ElemsPaths.ADRESS_FIELD, adress);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Step("Press New letter button")
    private void createNewLetter() {
        try {
            handler.click(handler.getElem(ElemsPaths.NEW_LETTER));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void createAndSendQALetter(String adress, String theme) {
        String letterBody = getResultFromIncomingLetters();
        createNewLetter();
        setAdress(adress);
        setTheme(theme);
        setLetterBody(letterBody);
        sendLetter();
        handler.waitSomeTime(10000);

    }
}
