import config.SeleniumHandler;
import model.Mail;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.AutoQALogin;
import pages.AutoQAMailPage;
import scraper.ElemsPaths;

public class TestLoginAndSendLetter {

    private static final String BASE_URL = "https://www.gmail.com/";
    private static final String TEST_GMAIL_COM = "100820.test@gmail.com";
    private static final String TEST_PASSWORD = "#EDC4rfv";
    private static final String ADRESS = "timoshenkomaria@mail.ru";
    private static final String THEME = "Тестовое задание. Лупандина";

    private SeleniumHandler handler = new SeleniumHandler();
    AutoQALogin qaLogin;
    AutoQAMailPage qaMailPage;

    private void startGrawling() {
        if(handler.start(false,true)) {
            qaLogin = new AutoQALogin(handler);
            qaMailPage = new AutoQAMailPage(handler);

            qaLogin.loginToAutoQA(BASE_URL,TEST_GMAIL_COM,TEST_PASSWORD);

            qaMailPage.createAndSendQALetter(ADRESS,THEME);

            handler.waitSomeTime(10000);
            handler.stop();
        }

    }

    public static void main(String[] args) {
        TestLoginAndSendLetter test = new TestLoginAndSendLetter();
        test.startGrawling();
    }
}
