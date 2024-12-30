package br.com.kumabe.to_do_list.infrastructure.adapter.persistence;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="todos")
public class ToDoEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "completed")
    private Boolean completed;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public ToDoEntity(){}

    public ToDoEntity(Boolean completed, LocalDateTime createdAt, String description, Integer id, String title) {
        this.completed = completed;
        this.createdAt = createdAt;
        this.description = description;
        this.id = id;
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
