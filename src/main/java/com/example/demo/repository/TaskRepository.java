package com.example.demo.repository;

import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Integer> {

//    List<Task> findAll();
//    Task findById(Integer id);
    List<Task> findByTitle(String title);
    List<Task> findByUserUsername(String userName);


}
