package ru.buzynnikov.taskmanager.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.buzynnikov.taskmanager.dto.TaskDTO;
import ru.buzynnikov.taskmanager.dto.TaskStatusDTO;
import ru.buzynnikov.taskmanager.models.Task;
import ru.buzynnikov.taskmanager.models.TaskStatus;
import ru.buzynnikov.taskmanager.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private TaskService service;

    /*
        Пример запроса на добавление задачи
        {
            "description":"This is Task",
            "status":"IN_PROGRESS"
        }

        Используем объект TaskDTO, так как передаются только два поля из Task
     */
    @PostMapping("/addTask")
    public Task addTask(@RequestBody TaskDTO task){
        return service.addTask(task);
    }

    @GetMapping("/status/{status}")
    public Iterable<Task> showTaskByStatus(@PathVariable TaskStatus status){
        return service.showTaskByStatus(status);
    }
    @GetMapping("/all")
    public List<Task> showAllTask(){
        return service.showAllTask();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTaskById(@PathVariable Long id){
        service.deleteTask(id);
    }
//    Используем объект TaskStatusDTO, так как передаем в теле только TaskStatus
    @PutMapping("/update/{id}")
    public String updateTaskStatus(@PathVariable Long id, @RequestBody TaskStatusDTO status){
        return "Обновлено записей: " + service.updateTaskStatus(id,status);
    }
}
