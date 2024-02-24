package com.example.demo.repository;

import com.example.demo.entity.Luz;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LuzRepository extends JpaRepository<Luz,Integer> {
//    @Query(value = "SELECT * FROM luz WHERE piso = ?1", nativeQuery = true)
//    List<Luz> buscarporPiso(int x);
    @Query("FROM Luz l WHERE l.piso = :number")//native query by default is false
    List<Luz> buscarporPiso(@Param("number") int x); //JPQL
    List<Luz> findByPiso(Integer piso); //JPA
    List<Luz> findByCasa(String casa); //JPA
    @Query("FROM Luz l WHERE l.casa= :string")
    List<Luz> buscarporNombre(@Param("string") String y); //JPQL
    List<Luz> findAll(Sort sort); //JPA
    List<Luz> findByImporte(Integer importe); //JPA



    }