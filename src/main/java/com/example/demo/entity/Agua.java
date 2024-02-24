package com.example.demo.entity;

import jakarta.persistence.*;
@Entity
public class Agua { //water
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @Column(name = "casa")
        private String casa;
        @Column(name = "piso")
        private Integer piso;
        @Column(name = "metrocubico")
        private Float metroCubico;
        @Column(name = "importe")
        private Float importe;

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

    public Float getMetroCubico() {
        return metroCubico;
    }

    public void setMetroCubico(Float metroCubico) {
        this.metroCubico = metroCubico;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }
}
