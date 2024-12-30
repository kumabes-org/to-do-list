package br.com.kumabe.to_do_list.application.port.input;

import br.com.kumabe.to_do_list.domain.model.ToDo;

import java.util.List;

public interface ToDoUseCase {
    public void create(ToDo toDo);
    public ToDo retrieve(Integer id);
    public void update(Integer id, ToDo toDo);
    public void delete(Integer id);
    public List<ToDo> list();
}
