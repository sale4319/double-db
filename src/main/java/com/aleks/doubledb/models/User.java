package com.aleks.doubledb.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String position;
    @NotEmpty
    private String department;
    /*@Id
    @Email
    @NotEmpty
    @Column(unique=true)
    private String email;*/
    @NotEmpty
    private String updateOn;

    public User() {

    }

    public User(Integer id, String name, String position, String department, String updateOn) {
        Id = id;
        this.name = name;
        this.position = position;
        this.department = department;
        //this.email = email;
        this.updateOn = updateOn;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    /*public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }*/

    public String getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(String updateOn) {
        this.updateOn = updateOn;
    }
}
