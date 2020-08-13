import config.SeleniumHandler;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AutoQALoginPage;
import pages.AutoQAMailPage;

public class TestLoginAndSendLetter {

    private static final String BASE_URL = "https://www.gmail.com/";
    private static final String TEST_GMAIL_COM = "100820.test@gmail.com";
    private static final String TEST_PASSWORD = "#EDC4rfv";
    private static final String ADRESS = "farit.valiahmetov@simbirsoft.com";
    private static final String THEME = "Тестовое задание. Лупандина";

    private SeleniumHandler handler = new SeleniumHandler();
    AutoQALoginPage qaLogin;
    AutoQAMailPage qaMailPage;

    @Description("Open browser")
    @BeforeTest
    private void initialization() {
        if(handler.start(false,true)) {
            qaLogin = new AutoQALoginPage(handler);
            handler.openPage(BASE_URL);
            System.out.println("open page: " + BASE_URL);
            qaMailPage = new AutoQAMailPage(handler);
        }
    }

    @Description("Login")
    @Story("Enter login and password")
    @Test
    private void login() {
        qaLogin.loginToAutoQA(TEST_GMAIL_COM,TEST_PASSWORD);
    }

    @Description("create letter")
    @Story("Create and send letter")
    @Test
    private void sendLetter() {
        qaMailPage.createALetter(ADRESS,THEME);
    }

    @Description("Close browser")
    @AfterTest
    private void stop() {
        //handler.stop();
    }
}
