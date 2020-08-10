package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mail {

    private String mail;
    private String url;
    private String login;
    private String password;
    private int countLetters;
}
