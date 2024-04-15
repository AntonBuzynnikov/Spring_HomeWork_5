package ru.buzynnikov.taskmanager.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.buzynnikov.taskmanager.models.Task;
import ru.buzynnikov.taskmanager.models.TaskStatus;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(
            value = "SELECT * FROM task t WHERE t.status = ?",
            nativeQuery = true
    )
    Iterable<Task> findByStatus(int status);
    @Modifying
    @Query(
            value = "UPDATE task SET status = ? WHERE id = ?",
            nativeQuery = true
    )
    @Transactional
    int updateTask(int status, Long id);
}
