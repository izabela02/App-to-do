package pl.sda.todo.mapper;

import pl.sda.todo.entity.ToDoEntity;
import pl.sda.todo.model.Category;
import pl.sda.todo.model.ToDoModel;
import pl.sda.todo.service.IdGeneratorService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ToDoMapper {

    public static final String YES = "Y";
    public static final String NO = "N";

    public static List<ToDoModel> map(List<ToDoEntity> entities) {
        return entities.stream()
                .map(ToDoMapper::map)
                .collect(Collectors.toList());
    }

    public static ToDoModel map(ToDoEntity entity) {
        return ToDoModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .category(Category.valueOf(entity.getCategory()))
                .creationDate(entity.getCreationDate())
                .deadline(entity.getDeadline())
                .done(entity.getDone().equals(YES))
                .build();
    }

    public static ToDoEntity map(String login, ToDoModel model) {
        return ToDoEntity.builder()
                .id(IdGeneratorService.generateId())
                .name(model.getName())
                .category(model.getCategory().toString())
                .creationDate(LocalDateTime.now())
                .deadline(model.getDeadline())
                .description(model.getDescription())
                .login(login)
                .done(NO)
                .build();
    }
}


