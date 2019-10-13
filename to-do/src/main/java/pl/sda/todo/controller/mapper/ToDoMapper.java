package pl.sda.todo.controller.mapper;

import pl.sda.todo.model.Category;
import pl.sda.todo.model.ToDoModel;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class ToDoMapper {
    public static ToDoModel map(HttpServletRequest request) {
        ToDoModel toDoModel = ToDoModel.builder()
                .name(request.getParameter("title"))
                .category(Category.valueOf(request.getParameter("category")))
                .deadline(LocalDateTime.parse(request.getParameter("deadline")))
                .description(request.getParameter("description"))
                .build();
        return toDoModel;
    }
}
