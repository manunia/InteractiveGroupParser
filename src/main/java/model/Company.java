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

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
