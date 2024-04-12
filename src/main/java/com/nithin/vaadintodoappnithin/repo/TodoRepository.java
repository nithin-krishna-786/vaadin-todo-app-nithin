package com.nithin.vaadintodoappnithin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nithin.vaadintodoappnithin.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
