package com.example.demo.service;

import com.example.demo.entity.Agua;
import com.example.demo.entity.Luz;
import com.example.demo.repository.WaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class WaterService {
    @Autowired
    WaterRepository waterRepository;

    public List<Agua> aguaSelect(){
        return waterRepository.findAll(); //SELECT
    }
    public void aguaDelete(Integer x){
        waterRepository.deleteById(x); //DELETE
    }
    public Agua aguaInsert(Agua x){
        return waterRepository.save(x); //INSERT AND UPDATE
    }
    public Agua aguaGet(Integer x){
        return waterRepository.findById(x).orElse(new Agua()); //GET
    }
    public List<Agua> orderByattributes(String atribute, String direction){ //SORT BY ATRIBUTE ASC/DES
        Sort sort = Sort.by(Sort.Direction.fromString(direction), atribute);
        return waterRepository.findAll(sort);
    }
    }



