package com.example.demo.dtos;

import java.util.List;

public class Hero {
    private Integer id;
    private String name;
    private String localize_name;
    private String primary_attr;
    private String attack_type;
    private List<String> roles;
    private String legs;

    public Hero(Integer id, String name, String localize_name, String primary_attr, String attack_type, List<String> roles, String legs) {
        this.id = id;
        this.name = name;
        this.localize_name = localize_name;
        this.primary_attr = primary_attr;
        this.attack_type = attack_type;
        this.roles = roles;
        this.legs = legs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalize_name() {
        return localize_name;
    }

    public void setLocalize_name(String localize_name) {
        this.localize_name = localize_name;
    }

    public String getPrimary_attr() {
        return primary_attr;
    }

    public void setPrimary_attr(String primary_attr) {
        this.primary_attr = primary_attr;
    }

    public String getAttack_type() {
        return attack_type;
    }

    public void setAttack_type(String attack_type) {
        this.attack_type = attack_type;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getLegs() {
        return legs;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }
    //    "id": 2,
//            "name": "npc_dota_hero_axe",
//            "localized_name": "Axe",
//            "primary_attr": "str",
//            "attack_type": "Melee",
//            "roles": [
//            "Initiator",
//            "Durable",
//            "Disabler",
//            "Carry"
//            ],
//            "legs": 2
}
