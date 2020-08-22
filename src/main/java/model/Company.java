package model;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {

    private String name;
    private String date;
    private String adress;

    private String description;

    @Step("Company: {0}")
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
