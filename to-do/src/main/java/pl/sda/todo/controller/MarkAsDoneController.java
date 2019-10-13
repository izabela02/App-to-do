package pl.sda.todo.controller;

import pl.sda.todo.service.ToDoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/to-do/markAsDone")
public class MarkAsDoneController extends HttpServlet {

    private ToDoService toDoService = new ToDoService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String toDoId = req.getParameter("toDoId");
        toDoService.markAsDone(Long.valueOf(toDoId));
        resp.sendRedirect(req.getContextPath() + "/to-do/home");
    }
}
