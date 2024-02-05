package com.mercedes.app.rest.Repository;

import com.mercedes.app.rest.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task, Long> {

}
