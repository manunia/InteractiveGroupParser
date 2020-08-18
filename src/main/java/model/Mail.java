package model;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mail {

    private int countLetters;

    @Step("Enter count of letters {0}")
    @Description("Set count of letters")
    public void setCountLetters(String countOfLetters) {
        try {
            countLetters = Integer.parseInt(countOfLetters);
        } catch (Exception e) {
            System.out.println("Error parsing count of letters " + e.getMessage());
        }

    }

    @Override
    public String toString() {
        return "Количество входящих писем: " + countLetters;
    }
}
