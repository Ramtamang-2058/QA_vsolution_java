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
public class Message {
    protected int id;
    protected String message;
    protected int receive_by_id;
    protected int send_by_id;
    protected int category_id;
    protected Date created_date;
    protected Date edited_date;
    protected String user;
    protected String profile;
    protected String receiver;

    public Message() {}

    public Message(String message, Date created_date, Date edited_date, int receive_by_id, int send_by_id) {
        super();
        this.message = message;
        this.receive_by_id = receive_by_id;
        this.send_by_id = send_by_id;
        this.created_date = created_date;
        this.edited_date = edited_date;
    }

    public Message(int id, String message, Date created_date, Date edited_date, int receive_by_id, int send_by_id) {
        super();
        this.id = id;
        this.message = message;
        this.receive_by_id = receive_by_id;
        this.send_by_id = send_by_id;
        this.created_date = created_date;
        this.edited_date = edited_date;
    }
    
    public Message(int id, String message, String user, String profile, Date created_date, Date edited_date) {
        super();
        this.id = id;
        this.message = message;
        this.user = user;
        this.profile = profile;
        this.created_date = created_date;
        this.edited_date = edited_date;
    }
    
    public Message(int id, String message, String user, String receiver, String profile, Date created_date, Date edited_date, int receive_by_id, int send_by_id) {
        super();
        this.id = id;
        this.message = message;
        this.user = user;
        this.receiver = receiver;
        this.profile=profile;
        this.receive_by_id = receive_by_id;
        this.send_by_id = send_by_id;
        this.created_date = created_date;
        this.edited_date = edited_date;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getReceive_by() {
        return receive_by_id;
    }
    public void setReceive_by(int receive_by_id) {
        this.receive_by_id = receive_by_id;
    }
    public int getSend_by() {
        return send_by_id;
    }
    
    public void setSend_by(int send_by_id) {
        this.send_by_id = send_by_id;
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
    public String getReceiver(){
        return receiver;
    }
    
    public void setReceiver(String receiver){
        this.receiver = receiver;
    }
    public String getProfile(){
        return profile;
    }
    public void setProfile(String profile){
        this.profile = profile;
    }
}
