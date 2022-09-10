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
public class Question {
    protected int id;
    protected String code;
    protected String question;
    protected int created_by_id;
    protected String user;
    protected String profile;
    protected int category_id;
    protected String image;
    protected Date created_date;
    protected Date edited_date;
    protected String semester;
    protected String faculty;
    protected String subject;

    public Question() {}

    public Question(String code, String question, String image, Date created_date, Date edited_date, int category_id, int created_by_id) {
        super();
        this.code = code;
        this.question = question;
        this.created_by_id = created_by_id;
        this.category_id = category_id;
        this.image = image;
        this.created_date = created_date;
        this.edited_date = edited_date;
    }

    public Question(int id, String question, String image, Date edited_date, int category_id, int created_by_id) {
        super();
        this.id = id;
        this.question = question;
        this.image= image;
        this.edited_date = edited_date;
        this.category_id = category_id;
        this.created_by_id = created_by_id;
    }
    
    public Question(int id, String code, String question, String image, Date created_date, Date edited_date, int category_id, int created_by_id) {
        super();
        this.id = id;
        this.code = code;
        this.question = question;
        this.image= image;
        this.created_date= created_date;
        this.edited_date = edited_date;
        this.category_id = category_id;
        this.created_by_id = created_by_id;
    }
    
    public Question(int id, String code, String question, String image, String user, String profile, Date created_date, Date edited_date, int category_id, int created_by_id, String semester, String subject, String faculty) {
        super();
        this.id = id;
        this.code = code;
        this.question = question;
        this.image= image;
        this.user = user;
        this.profile = profile;
        this.created_date= created_date;
        this.edited_date = edited_date;
        this.category_id = category_id;
        this.created_by_id = created_by_id;
        this.semester = semester;
        this.faculty = faculty;
        this.subject = subject;
    }

    public Question(String text, String fileName, Date created_date, Date edited_date, int category_id, int created_by_id, String code, String semester, String subject, String faculty) {
        this.question = text;
        this.image = fileName;
        this.created_date = created_date;
        this.edited_date = edited_date;
        this.category_id = category_id;
        this.created_by_id = created_by_id;
        this.semester = semester;
        this.faculty = faculty;
        this.subject = subject;
        this.code = code;
    }
    public Question(int id, String text, String fileName,  Date edited_date, int category_id, int created_by_id, String code, String semester, String subject, String faculty) {
        this.id = id;
        this.question = text;
        this.image = fileName;
        this.edited_date = edited_date;
        this.category_id = category_id;
        this.created_by_id = created_by_id;
        this.semester = semester;
        this.faculty = faculty;
        this.subject = subject;
        this.code = code;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public int getCreated_by() {
        return created_by_id;
    }
    public void setCreated_by(int created_by_id) {
        this.created_by_id = created_by_id;
    }
    public int getCategory() {
        return category_id;
    }
    public void setCategory(int category_id) {
        this.category_id = category_id;
    }
    public String getImage(){
        return image;
    }
    public void setImage(String image)
    {
        this.image = image;
    }
    public Date getCreated_date(){
        return created_date;
    }
    public void setCreated_date(Date created_date){
        this.created_date = created_date;
    }
    public Date getEdited_date(){
        return edited_date;
    }
    public void setEdited_ate(Date edited_date){
        this.edited_date = edited_date;
    }
    public String getUser(){
        return user;
    }
    
    public void setUser(String user){
        this.user = user;
    }
    
    public String getProfile(){
        return profile;
    }
    public void setProfile(String profile){
        this.profile = profile;
    }
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }

    public String getSemester() {
        return semester;
    }
    
    public void setSemester(String semester){
        this.semester=semester;
    }

    public String getSubject() {
        return subject;
    }
    public void seSubject(String subject){
        this.subject= subject;
    }

    public String getFaculty() {
        return faculty;
    }
    public void setFaculty(String faculty){
        this.faculty = faculty;
    }
}
