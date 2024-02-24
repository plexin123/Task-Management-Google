package com.example.demo.entity;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Luz { //energy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "casa")
    private String casa;
    @Column(name = "piso")
    private Integer piso;
//    @Column(name = "currentConsumption")
//    private Integer current;
    @Column(name = "kwats")
    private Float kwats;
    @Column(name = "importe")
    private Float importe;
    @ManyToOne //
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name ="start_Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @Column(name ="end_Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

//    public Integer getCurrent() {
//        return current;
//    }
//
//    public void setCurrent(Integer current) {
//        this.current = current;
//    }

    public Luz() {
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Luz{" +
                "id=" + id +
                ", casa='" + casa + '\'' +
                ", piso=" + piso +
                ", kwats=" + kwats +
                ", importe=" + importe +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public Float getKwats() {
        return kwats;
    }

    public void setKwats(Float kwats) {
        this.kwats = kwats;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }


}
