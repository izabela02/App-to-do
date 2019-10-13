package pl.sda.todo.dao;

import pl.sda.todo.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static List<UserEntity> users = populateUsers();

    public UserEntity getUserByLogin(String login) {
        return users.stream().filter(u -> u.getLogin().equals(login)).findFirst().orElse(null);
    }

    public boolean add(UserEntity userEntity) {
        return users.add(userEntity);
    }

    private static List<UserEntity> populateUsers() {
        List<UserEntity> mockUsers = new ArrayList<>();
        UserEntity user = UserEntity.builder()
                .login("janusz")
                .email("janusz@janusz.janusz")
                .password("janusz")
                .build();
        UserEntity user1 = UserEntity.builder()
                .login("grazyna")
                .email("grażyna@grażyna.pl")
                .password("grazyna")
                .build();
        mockUsers.add(user);
        mockUsers.add(user1);
        return mockUsers;
    }
}
