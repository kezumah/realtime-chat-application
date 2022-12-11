package com.example.distributedtexteditor.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SingleThreadSocketServer {
    private Socket socket;
    private OutputStream s1out;
    private InputStream s1In;

    PrintWriter oos;

    InputStreamReader ois;

    int counter = 0;

    //JSONObject message;


    public SingleThreadSocketServer(){
    }

    public void execute() throws IOException, InterruptedException {
        this.s1out = socket.getOutputStream();
        this.s1In = socket.getInputStream();
        this.oos = new PrintWriter(s1out,true);
        this.ois = new InputStreamReader(s1In);

        while(true){
            counter ++;
            String value = "Message " + counter + ": This message is coming from a server thread @ pid: " + Thread.currentThread().getName();
            JSONObject message = new JSONObject();
            message.put("message", value);
            System.out.println("sending " + message);
            sendMessageToClient(message);
            //System.out.println(message);
            //System.out.println("message sent");
            Thread.sleep(2000);
        }
    }

    public void setSocket(Socket socket){
        this.socket = socket;
    }

    public void sendMessageToClient(JSONObject message) throws IOException {
        // Send transformed string back to client
        oos.println(message.toString());

    }

}