/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.sql.Date;

/**
 *
 * @author ram
 */
public class User {
    protected int id;
    protected String fullname;
    protected String email;
    protected String username;
    protected String password;
    protected String role;
    protected String profile;
    protected String semester;
    protected String faculty;

    public User() {}

    public User(String fullname, String email, String username, String password, String role, String profile, String semester, String faculty) {
        super();
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.profile = profile;
        this.semester = semester;
        this.faculty = faculty;
    }

    public User(int id, String fullname, String email, String username, String password, String role, String profile, String semester, String faculty) {
        super();
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.profile = profile;
        this.semester = semester;
        this.faculty = faculty;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email=email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username=username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }
    public String getProfile(){
        return profile;
    }
    public void setProfile(String profile){
        this.profile = profile;
    }
    public String getSemester(){
        return semester;
    }
    
    public void setSemester(String semester){
        this.semester=semester;
    }
    public String getFaculty(){
        return faculty;
    }
    
    public void setFaculty(String faculty){
        this.faculty=faculty;
    }
}
