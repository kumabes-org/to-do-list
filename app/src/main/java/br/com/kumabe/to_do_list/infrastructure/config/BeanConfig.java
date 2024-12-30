package br.com.kumabe.to_do_list.infrastructure.config;

import br.com.kumabe.to_do_list.application.port.input.ToDoUseCase;
import br.com.kumabe.to_do_list.application.port.output.ToDoRepository;
import br.com.kumabe.to_do_list.application.service.ToDoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ToDoUseCase toDoUseCase(ToDoRepository toDoRepository){
        return new ToDoService(toDoRepository);
    }

}
