package scraper;

public class ElemsPaths {

    public static final String LOGIN_FIELD = "//*[@id='identifierId']";
    public static final String PASSWORD_FIELD = "//*[@id='password']/div[1]/div/div[1]/input";

    public static final String INCOMING_LETTERS = "//*[@data-tooltip='Входящие']";
    public static final String LETTERS = "//*[@class='bsU']";//т.к. мы находим дочерний элемент из блока входящих, то можно искать по классу

    public static final String NEW_LETTER = "//*[@class='aic']/div/div";

    public static final String ADRESS_FIELD = "//*[@name='to']";
    public static final String THEME_FIELD = "//*[@name='subjectbox']";
    public static final String LETTER_BODY = "//*[@class='Ar Au']/div[@aria-label='Тело письма']";
    public static final String SEND_BUTTON = "//*[@class='dC']/div";
}
