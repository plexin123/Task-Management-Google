package com.example.demo.repository;

import com.example.demo.entity.Agua;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterRepository extends JpaRepository<Agua,Integer> {
}
