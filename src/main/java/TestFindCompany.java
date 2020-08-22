import config.SeleniumHandler;
import io.qameta.allure.Description;
import model.Company;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RusProfilePage;
import pages.ListCompaniesPage;

import java.util.ArrayList;
import java.util.List;

public class TestFindCompany {

    private static final String BASE_URL = "https://www.rusprofile.ru/";

    private SeleniumHandler handler = new SeleniumHandler();
    RusProfilePage rusProfilePage;
    ListCompaniesPage companiesPage;

    @Description("Open browser")
    @BeforeTest
    private void initialization() {
        if(handler.start(false,false)) {
            rusProfilePage = new RusProfilePage(handler);
            handler.openPage(BASE_URL);
            System.out.println("open page: " + BASE_URL);

            companiesPage = new ListCompaniesPage(handler);
        }
    }

    @Description("Find companies")
    @Test
    private void findCompanies() {
        rusProfilePage.findAllCompanies(26);
    }

    @Description("List of companies")
    @Test
    private void listOfCompanies() {
        companiesPage.getList();
    }

    @Description("Close browser")
    @AfterTest
    private void stop() {

        //handler.stop();
    }
}
