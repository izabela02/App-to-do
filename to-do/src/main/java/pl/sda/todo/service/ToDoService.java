package pl.sda.todo.service;

import pl.sda.todo.dao.ToDoDao;
import pl.sda.todo.mapper.ToDoMapper;
import pl.sda.todo.model.ToDoModel;

import java.util.List;

import static pl.sda.todo.mapper.ToDoMapper.YES;
import static pl.sda.todo.mapper.ToDoMapper.map;

public class ToDoService {

    private ToDoDao toDoDao = new ToDoDao();

    public List<ToDoModel> getToDo(String login) {
        return map(toDoDao.getEntities(login));
    }

    public boolean markAsDone(Long id) {
        return toDoDao.updateStatus(id, YES);
    }

    public boolean addToDo(String login, ToDoModel toDoModel) {
        return toDoDao.add(ToDoMapper.map(login,toDoModel));
    }
}
