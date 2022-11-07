/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.secure;
import java.util.Base64;/**
 *
 * @author ram
 */
public class Encrypt {

    public String encryptPassword(String password) {
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedpassword = encoder.encodeToString(password.getBytes());
        return encryptedpassword;
    }
}