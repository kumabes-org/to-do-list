package br.com.kumabe.to_do_list.infrastructure.adapter.rest;

import br.com.kumabe.to_do_list.application.port.input.ToDoUseCase;
import br.com.kumabe.to_do_list.domain.model.ToDo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoController {
    private final ToDoUseCase toDoUseCase;

    public ToDoController(final ToDoUseCase toDoUseCase){
        this.toDoUseCase = toDoUseCase;
    }

    @PostMapping(path="/v1/todos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createToDo(@RequestBody ToDoRequest toDoRequest, UriComponentsBuilder uriComponentsBuilder){
        ToDo toDo = new ToDo(
                toDoRequest.getCompleted(),
                toDoRequest.getCreatedAt(),
                toDoRequest.getDescription(),
                toDoRequest.getId(),
                toDoRequest.getTitle()
        );
        toDoUseCase.create(toDo);
        URI location = uriComponentsBuilder.path("/api/v1/todos/{id}").buildAndExpand(toDo.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path="/v1/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ToDo>> getAllToDos(){
        return ResponseEntity.ok(toDoUseCase.list());
    }


    @GetMapping(path="/v1/todos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ToDo> getToDoById(@PathVariable Integer id){
        return ResponseEntity.ok(toDoUseCase.retrieve(id));
    }
}
