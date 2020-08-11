import config.SeleniumHandler;
import model.Mail;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import scraper.ElemsPaths;

public class ScraperApp {

    private static final String BASE_URL = "https://www.gmail.com/";
    private static final String TEST_GMAIL_COM = "100820.test@gmail.com";
    private static final String TEST_PASSWORD = "#EDC4rfv";
    private static final String ADRESS = "timoshenkomaria@mail.ru";
    private static final String THEME = "Тестовое задание. Лупандина";

    private SeleniumHandler handler = new SeleniumHandler();

    private void startGrawling() {
        if(handler.start(false,true)) {
            handler.openPage(BASE_URL);
            System.out.println("open page: " + BASE_URL);

            setLogin();
            handler.waitSomeTime(5000);
            setPassword();

            handler.waitSomeTime(10000);

            WebElement mail = handler.getElem(ElemsPaths.INCOMING_LETTERS);
            Mail result = parseMail(mail);
            System.out.println(result.toString());

            createNewLetter();

            setAdress(ADRESS);
            setTheme(THEME);
            setLetterBody(result.toString());


            //handler.stop();
        }

    }

    private void setLetterBody(String s) {
        try {
            handler.setTextToElement(ElemsPaths.LETTER_BODY, s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void setTheme(String theme) {
        try {
            handler.setTextToElement(ElemsPaths.THEME_FIELD, theme);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void setAdress(String adress) {
        try {
            handler.setTextToElement(ElemsPaths.ADRESS_FIELD, adress);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void setLogin() {
        try {
            handler.setTextToElement(ElemsPaths.LOGIN_FIELD, TEST_GMAIL_COM + Keys.ENTER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void setPassword() {
        try {
            handler.setTextToElement(ElemsPaths.PASSWORD_FIELD, TEST_PASSWORD + Keys.ENTER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Mail parseMail(WebElement mail) {
        Mail mailObj = new Mail();

        mailObj.setCountLetters(handler.getChildElemText(ElemsPaths.LETTERS,mail));
        return mailObj;
    }

    private void createNewLetter() {
        try {
            handler.click(handler.getElem(ElemsPaths.NEW_LETTER));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        ScraperApp scraperApp = new ScraperApp();
        scraperApp.startGrawling();
    }
}
