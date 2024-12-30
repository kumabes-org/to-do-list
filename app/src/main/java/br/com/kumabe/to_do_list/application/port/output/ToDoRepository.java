package br.com.kumabe.to_do_list.application.port.output;

import br.com.kumabe.to_do_list.domain.model.ToDo;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ToDoRepository {
    public void save(ToDo toDo);
    public Optional<ToDo> findById(Integer id);
    public void deleteById(Integer id);
    public List<ToDo> findAll();
}
