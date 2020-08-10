import config.SeleniumHandler;

public class ScraperApp {

    private static final String BASE_URL = "gmail.com";
    private SeleniumHandler handler = new SeleniumHandler();

    private void startGrawling() {
        if(handler.start(false)) {
            handler.openPage(BASE_URL);
            System.out.println("open page: " + BASE_URL);
        }

    }

    public static void main(String[] args) {
        ScraperApp scraperApp = new ScraperApp();
        scraperApp.startGrawling();
    }
}
