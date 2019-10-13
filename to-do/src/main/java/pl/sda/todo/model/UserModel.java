package pl.sda.todo.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserModel {
    private String login;
    private String password;
    private String email;
}
