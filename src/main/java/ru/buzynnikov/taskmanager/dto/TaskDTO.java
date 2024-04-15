package ru.buzynnikov.taskmanager.dto;

import lombok.Data;
import ru.buzynnikov.taskmanager.models.TaskStatus;

@Data
public class TaskDTO {
    private String description;
    private TaskStatus status;
}
