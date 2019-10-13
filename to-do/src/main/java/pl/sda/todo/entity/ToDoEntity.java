package pl.sda.todo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
@Builder
public class ToDoEntity {
    private long id;
    private String login;
    private String name;
    private String description;
    private String category;
    private LocalDateTime creationDate;
    private LocalDateTime deadline;
    private String done;
}
