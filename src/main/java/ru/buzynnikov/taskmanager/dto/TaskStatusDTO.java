package ru.buzynnikov.taskmanager.dto;

import lombok.Data;
import ru.buzynnikov.taskmanager.models.TaskStatus;

@Data
public class TaskStatusDTO {
    private TaskStatus status;
}
