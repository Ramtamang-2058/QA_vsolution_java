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
public class Answer {
    protected int id;
    protected String code;
    protected String answer;
    protected int created_by_id;
    protected int question_id;
    protected String image;
    protected Date created_date;
    protected Date edited_date;
    protected String user;

    public Answer() {}

    public Answer(String code, String image, String answer, Date created_date, Date edited_date, int created_by_id, int question_id) {
        super();
        this.answer = answer;
        this.code = code;
        this.created_by_id = created_by_id;
        this.question_id = question_id;
        this.image = image;
        this.created_date= created_date;
        this.edited_date = edited_date;
    }

    public Answer(int id, String code, String image, String answer, Date created_date, Date edited_date, int question_id, int created_by_id) {
        super();
        this.id = id;
        this.code = code;
        this.answer = answer;
        this.image= image;
        this.created_date= created_date;
        this.edited_date = edited_date;
        this.question_id = question_id;
        this.created_by_id = created_by_id;
    }
    
    public Answer(int id, String code, String image, String answer, String user, Date created_date, Date edited_date, int question_id, int created_by_id) {
        super();
        this.id = id;
        this.code = code;
        this.answer = answer;
        this.image= image;
        this.user = user;
        this.created_date= created_date;
        this.edited_date = edited_date;
        this.question_id = question_id;
        this.created_by_id = created_by_id;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public int getCreated_by() {
        return created_by_id;
    }
    public void setCreated_by(int created_by_id) {
        this.created_by_id = created_by_id;
    }
    public int getQuestion() {
        return question_id;
    }
    public void setCategory(int question_id) {
        this.question_id = question_id;
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
    public void setEdited_date(Date edited_date){
        this.edited_date = edited_date;
    }
    
    public String getUser(){
        return user;
    }
    
    public void setUser(String user){
        this.user = user;
    }

    public Date getCreatedDate() {
        return created_date;
    }
    public void setCreatedDate(Date created_date){
        this.created_date=created_date;
    }
    
    public void setEditedDate(Date edited_date){
        this.edited_date=edited_date;
    }
    
    public Date getEditedDate() {
        return edited_date;
    }
    
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
}
