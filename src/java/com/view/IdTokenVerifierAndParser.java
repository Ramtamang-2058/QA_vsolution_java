///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package com.view;
//
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.jackson.JacksonFactory;
//
//public class IdTokenVerifierAndParser {
//
//    private static final String GOOGLE_CLIENT_ID = "928543276217-chqj9oam8f18aiul3uva3630d6cd0jkn.apps.googleusercontent.com";
//
//    public static GoogleIdToken.Payload getPayload (String tokenString) throws Exception {
//
//        JacksonFactory jacksonFactory = new JacksonFactory();
//        GoogleIdTokenVerifier googleIdTokenVerifier =
//                            new GoogleIdTokenVerifier(new NetHttpTransport(), jacksonFactory);
//
//        GoogleIdToken token = GoogleIdToken.parse(jacksonFactory, tokenString);
//
//        if (googleIdTokenVerifier.verify(token)) {
//            GoogleIdToken.Payload payload = token.getPayload();
//            if (!GOOGLE_CLIENT_ID.equals(payload.setAudience(token))) {
//                throw new IllegalArgumentException("Audience mismatch");
//            } else if (!GOOGLE_CLIENT_ID.equals(payload.setAuthorizedParty())) {
//                throw new IllegalArgumentException("Client ID mismatch");
//            }
//            return payload;
//        } else {
//            throw new IllegalArgumentException("id token cannot be verified");
//        }
//    }
//}
