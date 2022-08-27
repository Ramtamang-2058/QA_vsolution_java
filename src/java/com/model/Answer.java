/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;
/**
 *
 * @author ram
 */
public class Answer {
    protected int id;
    protected String answer;
    protected int created_by_id;
    protected int question_id;
    protected String image;
    protected String created_date;
    protected String edited_date;
    protected String user;

    public Answer() {}

    public Answer(String image, String answer, int question_id, int created_by_id) {
        super();
        this.answer = answer;
        this.created_by_id = created_by_id;
        this.question_id = question_id;
        this.image = image;
    }

    public Answer(int id, String image, String answer, String created_date, String edited_date, int question_id, int created_by_id) {
        super();
        this.id = id;
        this.answer = answer;
        this.image= image;
        this.created_date= created_date;
        this.edited_date = edited_date;
        this.question_id = question_id;
        this.created_by_id = created_by_id;
    }
    
    public Answer(int id, String image, String user, String answer, String created_date, String edited_date, int question_id, int created_by_id) {
        super();
        this.id = id;
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
    public String getCreatedDate(){
        return created_date;
    }
    public void setCreatedDate(String created_date){
        this.created_date = created_date;
    }
    public String getEditedDate(){
        return edited_date;
    }
    public void setEditedDate(String edited_date){
        this.edited_date = edited_date;
    }
    
    public String getUser(){
        return user;
    }
    
    public void setUser(String user){
        this.user = user;
    }
}
