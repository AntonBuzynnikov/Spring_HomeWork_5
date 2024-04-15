package ru.buzynnikov.taskmanager.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 2000)
    private String description;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private TaskStatus status;
    @Column(name = "create_time")
    private LocalDateTime createTime;
}
