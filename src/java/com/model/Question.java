/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.security.ProtectionDomain;
import java.sql.Time;
import java.util.Base64;

import org.w3c.dom.Text;

/**
 *
 * @author ram
 */
public class Question {
    protected int id;
    protected String question;
    protected int created_by_id;
    protected int category_id;
    protected String image;
    protected String created_date;
    protected String edited_date;

    public Question() {}

    public Question(String question, String image, int category_id, int created_by_id) {
        super();
        this.question = question;
        this.created_by_id = created_by_id;
        this.category_id = category_id;
        this.image = image;
    }

    public Question(int id, String question, String image, String created_date, String edited_date, int category_id, int created_by_id) {
        super();
        this.id = id;
        this.question = question;
        this.image= image;
        this.created_date= created_date;
        this.edited_date = edited_date;
        this.category_id = category_id;
        this.created_by_id = created_by_id;
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
    public String getCreated_date(){
        return created_date;
    }
    public void setCreated_date(String created_date){
        this.created_date = created_date;
    }
    public String getEdited_date(){
        return edited_date;
    }
    public void setEdited_ate(String edited_date){
        this.edited_date = edited_date;
    }
}
