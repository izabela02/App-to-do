package pl.sda.todo.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserEntity {
    private String login;
    private String password;
    private String email;
}
