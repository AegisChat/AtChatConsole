/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atchat;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Messanger extends Thread{
    private String hostName; 
    private int portNumber;
    private Socket chatSocket;
    private PrintWriter write;
    private BufferedReader read;
    private static Messanger instance;
    
    private Messanger(){
        instance = null;
        hostName = "localhost";
        portNumber = 6688;
        try{
        chatSocket = new Socket(hostName, portNumber);
        write = new PrintWriter(chatSocket.getOutputStream(), true);
        read = new BufferedReader(new InputStreamReader(chatSocket.getInputStream()));
        }catch (Exception e) {
            System.err.println("Don't know about host " + hostName);
        }
    }
    
    public static Messanger getInstance(){
        if(instance == null) {
            instance = new Messanger();
        }
        return instance;
    }
    
    @Override
    public void run(){
        String serverInput = null;
        try{
        while((serverInput = read.readLine()) != null){
            
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void sendMessage(String message){
        ChatProtocol chat = new ChatProtocol();
        write.println(chat.ProccessOutput(message));
    }
}
