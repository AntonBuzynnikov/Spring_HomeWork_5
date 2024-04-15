package ru.buzynnikov.taskmanager.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.buzynnikov.taskmanager.dto.TaskDTO;
import ru.buzynnikov.taskmanager.dto.TaskStatusDTO;
import ru.buzynnikov.taskmanager.models.Task;
import ru.buzynnikov.taskmanager.models.TaskStatus;
import ru.buzynnikov.taskmanager.repositories.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository repository;

    // Добавление новой задачи
    public Task addTask(TaskDTO task){
        Task newTask = new Task();
        newTask.setDescription(task.getDescription());
        newTask.setStatus(task.getStatus());
        newTask.setCreateTime(LocalDateTime.now());
        return repository.save(newTask);
    }
    // Просмотр всех задач
    public List<Task> showAllTask(){
        return repository.findAll();
    }
    // Просмотр задач по статусу
    public Iterable<Task> showTaskByStatus(TaskStatus status){
        return repository.findByStatus(status.ordinal());
    }
//     Изменение статуса задачи
    public int updateTaskStatus(Long id, TaskStatusDTO status){
        return repository.updateTask(status.getStatus().ordinal(), id);
    }
    // Удаление задачи
    public void deleteTask(Long id){
        repository.deleteById(id);
    }
}
