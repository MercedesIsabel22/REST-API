package com.mercedes.app.rest.Controller;

import com.mercedes.app.rest.Model.Task;
import com.mercedes.app.rest.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;
    @GetMapping(value= "/")
    public String holaMundo(){
        return "HOLA MUNDO!!";
    }

    @GetMapping(value="/tasks")
    public List<Task> getTasks(){
        return todoRepository.findAll();
    }

    @PostMapping(value = "/savetask")
    public String saveTask(@RequestBody Task task){
        todoRepository.save(task);
        return "saved task";
    }

    @PutMapping(value ="/update/{id}")
    public String updateTask(@PathVariable long id,@RequestBody Task task){
        Task updateTask = todoRepository.findById(id).get();
        updateTask.setTitle(task.getTitle());
        updateTask.setDescripcion(task.getDescripcion());
        todoRepository.save(updateTask);
        return "update Task";
    }
    @DeleteMapping(value = "delete/{id}")
    public String deleteTask(@PathVariable long id){
        Task deleteTask = todoRepository.findById(id).get();
        todoRepository.delete(deleteTask);
        return "deleteT Task";
    }

}
