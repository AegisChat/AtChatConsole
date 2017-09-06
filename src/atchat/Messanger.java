/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atchat;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Messanger extends Thread{
    private String hostName; 
    private int portNumber;
    private Socket chatSocket;
    private PrintWriter write;
    private BufferedReader read;
    private static Messanger instance;
    private ChatProtocol chat;
    private static SocketChannel client;
    private static ByteBuffer buffer;
    private Charset charset;
    
    private Messanger(){
        chat = new ChatProtocol();
        instance = null;
        hostName = "localhost";
        portNumber = 18888;
        charset = Charset.forName("UTF-8");
        try{
            client = SocketChannel.open(new InetSocketAddress("localhost", portNumber));
            buffer = ByteBuffer.allocate(2000);
        }catch(IOException e){
            e.printStackTrace();
        }
//        try{
//        chatSocket = new Socket(hostName, portNumber);
//        write = new PrintWriter(chatSocket.getOutputStream(), true);
//        read = new BufferedReader(new InputStreamReader(chatSocket.getInputStream()));
//        }catch (Exception e) {
//            System.err.println("Don't know about host " + hostName);
//        }
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
            while(true){}

//            while((serverInput =charset.decode(buffer).toString()) !=null){
//
//            }
//          while((serverInput = read.readLine()) != null){
//
//          }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void sendMessage(String message){
        buffer = ByteBuffer.wrap(message.getBytes(Charset.forName("UTF-8")));
        try{
            client.write(buffer);
            buffer.clear();
        }catch(IOException e){
            e.printStackTrace();
        }
//        write.println(message);
//        write.flush();
    }
}
