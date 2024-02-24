package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/tasks",produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
public class TaskController {
    @Autowired
    TaskService taskService;
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAll(){
        return taskRepository.findAll();
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task taskInsert(@RequestBody Task task){
        return taskService.createTask(task);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task taskUpdate(@RequestBody Task task){
        return taskService.updateTask(task);
    }
    @DeleteMapping("/{id}")
    public void taskDelete(@PathVariable("id") int x ) {
        taskService.deleteTask(x);
    }
    @GetMapping("/{taskId}/dependencies")
    public ResponseEntity<List<Task>> getTaskDependencies(@PathVariable int taskId){
        Task task = taskRepository.findById(taskId).orElse(null);
        if(task != null) { // the task exist
            List<Task> dependencies = taskService.getDependeciesById(task);
            return new ResponseEntity<>(dependencies, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/userName/{userName}")
    public List<Task> getTaskbyUserId(@PathVariable String userName){
        List<Task> tasks = taskRepository.findByUserUsername(userName);
        return tasks;
    }
    @GetMapping("/title/{title}")
    public List<Task> getTaskByTitle(@PathVariable String title){
        List<Task> tasks = taskService.getTaskbyTaskName(title);
        return tasks;
    }
    @GetMapping("/prioritize")
    public ResponseEntity<List<Task>> prioritizeTasks(@RequestParam("criteria") String criteria){
        List<Task> tasks =taskService.getAll();
        List<Task> prioritizedTasks = taskService.prioritizeTasks(tasks, criteria);
        return new ResponseEntity<>(prioritizedTasks, HttpStatus.OK);
    }

}
