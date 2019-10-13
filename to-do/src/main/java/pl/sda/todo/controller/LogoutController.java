package pl.sda.todo.controller;

import pl.sda.todo.service.authentication.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/to-do/logout")
public class LogoutController extends HttpServlet {

    private AuthenticationService authenticationService = new AuthenticationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        authenticationService.logout(req);
        resp.sendRedirect("/login");
    }
}
