package pages;

import config.SeleniumHandler;
import io.qameta.allure.Step;
import model.Company;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListCompaniesPage {
    private static final String ALL_COMPANIES = "//*[@class='company-item']";

    private static final String ADRESS = ".//div[@class='company-item']/div[@class='company-item__text']";

    private SeleniumHandler handler;
    private List<Company> companyList;

    public ListCompaniesPage(SeleniumHandler handler) {
        this.handler = handler;
        this.companyList = new ArrayList<>();
    }

    @Step("Get companies list")
    public void getList() {
        List<WebElement> elements = handler.getElements(ALL_COMPANIES);
        for (WebElement e:elements) {
            if (e.getText().contains("Ростов-на-Дону") || e.getText().contains("Ростовская")) {
                System.out.println(e.getText());
            }
        }

    }
}
