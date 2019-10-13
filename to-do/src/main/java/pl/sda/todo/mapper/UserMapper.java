package pl.sda.todo.mapper;

import pl.sda.todo.entity.UserEntity;
import pl.sda.todo.model.UserModel;

public class UserMapper {
    public static UserEntity map(UserModel userModel) {
        return UserEntity.builder()
                .login(userModel.getLogin())
                .password(userModel.getPassword())
                .email(userModel.getEmail())
                .build();
    }

    public static UserModel map(UserEntity userEntity) {
        return userEntity == null ? null : UserModel.builder()
                .login(userEntity.getLogin())
                .password((userEntity.getPassword()))
                .email(userEntity.getEmail())
                .build();
    }
}
