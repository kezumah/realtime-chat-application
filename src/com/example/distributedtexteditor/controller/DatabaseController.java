<<<<<<<< HEAD:src/main/java/com/example/distributedtexteditor/controller/DatabaseController.java
package main.java.com.example.distributedtexteditor.controller;
========
package com.example.distributedtexteditor.controller;
>>>>>>>> main_adi:src/com/example/distributedtexteditor/controller/DatabaseController.java

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class DatabaseController {

    public static void createHashInDatabase(String hash){
        // needs to be implemented
    }

    public static ArrayList<String> getDocFromDatabase(String hash) {
        ArrayList<String> doc = new ArrayList<String>();
        // needs to be implemented
        return doc;
    }

    public static void saveDoc (String hash, ArrayList<String> doc){
        // needs to be implemented
    }
}