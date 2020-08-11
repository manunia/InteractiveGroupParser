package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mail {

    private int countLetters;

    public void setCountLetters(String childElemText) {
        try {
            countLetters = Integer.parseInt(childElemText);
        } catch (Exception e) {
            System.out.println("Error parsing count of letters " + e.getMessage());
        }

    }

    @Override
    public String toString() {
        return "Mail{" +
                "Количество входящих писем: " + countLetters +
                '}';
    }
}
