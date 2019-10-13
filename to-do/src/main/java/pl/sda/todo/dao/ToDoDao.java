package pl.sda.todo.dao;

import pl.sda.todo.entity.ToDoEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static pl.sda.todo.service.IdGeneratorService.generateId;

public class ToDoDao {

    private static List<ToDoEntity> entities = loadMockData();

    public List<ToDoEntity> getEntities(String login) {
        return entities.stream()
                .filter(toDoEntity -> toDoEntity.getLogin().equals(login))
                .collect(Collectors.toList());
    }

    public boolean updateStatus(long id, String status) {
        ToDoEntity toDo = getToDo(id);
        if (toDo != null) {
            toDo.setDone(status);
            return true;
        }
        return false;
    }

    public ToDoEntity getToDo(long id) {
        return entities.stream().filter(i -> i.getId() == id).findAny().orElse(null);
    }

    public boolean add(ToDoEntity toDoEntity) {
        return entities.add(toDoEntity);
    }

    private static List<ToDoEntity> loadMockData() {
        List<ToDoEntity> mockedEntities = new ArrayList<>();

        ToDoEntity entity1 = ToDoEntity.builder()
                .id(generateId())
                .login("janusz")
                .name("Zamówić zapiekanki")
                .description("Powinniśmy zamówić przepyszne zapiekanki z Zapiekarni")
                .category("RELAX")
                .creationDate(LocalDateTime.of(2019, 10, 5, 15, 3))
                .deadline(LocalDateTime.of(2019, 10, 6, 14, 0))
                .done("N")
                .build();

        ToDoEntity entity2 = ToDoEntity.builder()
                .id(generateId())
                .login("janusz")
                .name("Stworzyć Entity")
                .description("Jeszcze jedno")
                .category("WORK")
                .creationDate(LocalDateTime.of(2019, 10, 5, 15, 9))
                .deadline(LocalDateTime.of(2019, 10, 5, 16, 0))
                .done("Y")
                .build();

        mockedEntities.add(entity1);
        mockedEntities.add(entity2);
        return mockedEntities;
    }
}
