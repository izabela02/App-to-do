package pl.sda.todo.service;

import pl.sda.todo.dao.UserDao;
import pl.sda.todo.mapper.UserMapper;
import pl.sda.todo.model.UserModel;

public class UserService {

    private UserDao userDao = new UserDao();

    public UserModel getUserModelByLogin(String login) {
        return UserMapper.map(userDao.getUserByLogin(login));
    }
}
