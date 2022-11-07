/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.secure;
import java.util.Base64;
import java.util.Base64.Decoder;
/**
 *
 * @author ram
 */
public class Decrypt {
    public String decrypt(String password) {
        Decoder decoder = Base64.getDecoder();
        byte[] decodedpassword = decoder.decode(password);
        return new String(decodedpassword);
    }
    
}
