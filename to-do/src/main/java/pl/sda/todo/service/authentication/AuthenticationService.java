package pl.sda.todo.service.authentication;

import pl.sda.todo.model.UserModel;
import pl.sda.todo.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationService {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private UserService userService = new UserService();

    public boolean authenticate(HttpServletRequest request) {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        UserModel user = userService.getUserModelByLogin(login);
        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute(LOGIN, login);
            return true;
        } else {
            return false;
        }
    }

    public boolean isAuthenticated(HttpServletRequest request) {
        String login = (String) request.getSession().getAttribute(LOGIN);
        return login != null && !login.isEmpty();
    }

    public static String getUserLogin(HttpServletRequest request) {
        return (String) request.getSession().getAttribute(LOGIN);
    }

    public void logout(HttpServletRequest request) {
        request.getSession().removeAttribute(LOGIN);
    }
}
