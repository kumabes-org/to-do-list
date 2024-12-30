package br.com.kumabe.to_do_list.infrastructure.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataToDoRepository extends JpaRepository<ToDoEntity, Integer> {
}
