package br.com.kumabe.to_do_list.infrastructure.adapter.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ToDoRequest {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    @NotBlank
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("completed")
    private Boolean completed;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    public ToDoRequest(){}

    public ToDoRequest(Boolean completed, LocalDateTime createdAt, String description, Integer id, String title) {
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
