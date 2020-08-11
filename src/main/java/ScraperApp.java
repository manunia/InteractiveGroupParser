import config.SeleniumHandler;
import org.openqa.selenium.Keys;
import scraper.ElemsPaths;

public class ScraperApp {

    private static final String BASE_URL = "https://www.gmail.com/";
    private static final String TEST_GMAIL_COM = "100820.test@gmail.com";
    private static final String TEST_PASSWORD = "#EDC4rfv";

    private SeleniumHandler handler = new SeleniumHandler();

    public int letters;

    private void startGrawling() {
        if(handler.start(false,true)) {
            handler.openPage(BASE_URL);
            System.out.println("open page: " + BASE_URL);

            setLogin();
            handler.waitSomeTime(2000);
            setPassword();
            handler.waitSomeTime(5000);
            getLetters();


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

    private void getLetters() {
        try {
            letters = Integer.parseInt(handler.getElem(ElemsPaths.LETTERS).getText());
            System.out.println(letters);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ScraperApp scraperApp = new ScraperApp();
        scraperApp.startGrawling();
    }
}
