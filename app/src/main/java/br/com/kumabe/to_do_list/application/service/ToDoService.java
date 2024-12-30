package br.com.kumabe.to_do_list.application.service;

import br.com.kumabe.to_do_list.application.port.input.ToDoUseCase;
import br.com.kumabe.to_do_list.application.port.output.ToDoRepository;
import br.com.kumabe.to_do_list.domain.model.ToDo;

import java.time.LocalDateTime;
import java.util.List;

public class ToDoService implements ToDoUseCase {
    private final ToDoRepository toDoRepository;

    public ToDoService(final ToDoRepository toDoRepository){
        this.toDoRepository = toDoRepository;
    }

    @Override
    public void create(ToDo toDo) {
        toDo.setCreatedAt(LocalDateTime.now());
        toDoRepository.save(toDo);
    }

    @Override
    public ToDo retrieve(Integer id) {
        return toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("To-Do not found!"));
    }

    @Override
    public void update(Integer id, ToDo toDo) {
        ToDo existingToDo = retrieve(id);
        existingToDo.setTitle(toDo.getTitle());
        existingToDo.setDescription(toDo.getDescription());
        existingToDo.setCompleted(toDo.getCompleted());
        toDoRepository.save(existingToDo);
    }

    @Override
    public void delete(Integer id) {
        toDoRepository.deleteById(id);
    }

    @Override
    public List<ToDo> list() {
        return toDoRepository.findAll();
    }
}
