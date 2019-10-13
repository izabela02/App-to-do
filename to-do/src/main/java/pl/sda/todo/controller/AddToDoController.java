package pl.sda.todo.controller;

import pl.sda.todo.controller.mapper.ToDoMapper;
import pl.sda.todo.model.ToDoModel;
import pl.sda.todo.service.ToDoService;
import pl.sda.todo.service.authentication.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/to-do/add")
public class AddToDoController extends HttpServlet {

    ToDoService toDoService = new ToDoService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ToDoModel toDoModel = ToDoMapper.map(req);
        toDoService.addToDo(AuthenticationService.getUserLogin(req),toDoModel);
        resp.sendRedirect("/to-do/home");
    }
}
