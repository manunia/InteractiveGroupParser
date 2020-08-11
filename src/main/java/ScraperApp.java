import config.SeleniumHandler;
import scraper.ElemsPaths;

public class ScraperApp {

    private static final String BASE_URL = "https://www.google.ru/";
    private SeleniumHandler handler = new SeleniumHandler();

    private void startGrawling() {
        if(handler.start(false,true)) {
            handler.openPage(BASE_URL);
            System.out.println("open page: " + BASE_URL);

            setSorting();

            handler.waitSomeTime(2000);
        }

    }

    private void setSorting() {
        try {
            handler.click(handler.getElem(ElemsPaths.MAIL_LINK));
            handler.click(handler.getElem(ElemsPaths.ACCOUNT));
        } catch (Exception e) {
            handler.click(handler.getElem(ElemsPaths.MAIL_LINK_ALTERNATIVE));
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        ScraperApp scraperApp = new ScraperApp();
        scraperApp.startGrawling();
    }
}
