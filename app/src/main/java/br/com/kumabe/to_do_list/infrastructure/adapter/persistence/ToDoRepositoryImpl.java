package br.com.kumabe.to_do_list.infrastructure.adapter.persistence;

import br.com.kumabe.to_do_list.application.port.output.ToDoRepository;
import br.com.kumabe.to_do_list.domain.model.ToDo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ToDoRepositoryImpl implements ToDoRepository {
    private final SpringDataToDoRepository repository;

    public ToDoRepositoryImpl(SpringDataToDoRepository repository){
        this.repository = repository;
    }

    @Override
    public void save(ToDo toDo) {
        ToDoEntity entity = new ToDoEntity(
                toDo.getCompleted(),
                toDo.getCreatedAt(),
                toDo.getDescription(),
                toDo.getId(),
                toDo.getTitle()
        );
        repository.save(entity);
    }

    @Override
    public Optional<ToDo> findById(Integer id) {
        return repository.findById(id).map(entity -> new ToDo(
                entity.getCompleted(),
                entity.getCreatedAt(),
                entity.getDescription(),
                entity.getId(),
                entity.getTitle()
        ));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<ToDo> findAll() {
        return repository.findAll().stream()
                .map(entity -> new ToDo(
                        entity.getCompleted(),
                        entity.getCreatedAt(),
                        entity.getDescription(),
                        entity.getId(),
                        entity.getTitle()
                ))
                .collect(Collectors.toList());
    }
}
