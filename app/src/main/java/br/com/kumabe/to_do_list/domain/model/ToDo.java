package br.com.kumabe.to_do_list.domain.model;

import java.time.LocalDateTime;

public class ToDo {
    private Integer id;
    private String title;
    private String description;
    private Boolean completed;
    private LocalDateTime createdAt;

    public ToDo(){}

    public ToDo(Boolean completed, LocalDateTime createdAt, String description, Integer id, String title) {
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
