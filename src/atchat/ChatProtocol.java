/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atchat;

import java.util.UUID;
/**
 *
 * @author Avi
 * Relative to User using device
 */
public class ChatProtocol implements ChatProtocolInterface{
    
    private static Messanger messanger;
    private User user;
    
    public void ProccessOutput(String message){//get rid of this maybe
        user = User.getInstance();
        messanger = Messanger.getInstance();
        String messageSplit[] = message.split(" ");
        String content = messageSplit[1];
        String protocol = messageSplit[0];
        String output = null;
        switch(protocol){
            case "/000/":
                System.out.println(content);
                break; //message person
            case "/001/": 
                break; //find person
            case "/002/": 
                break; //person found
            case "/003/": 
                messanger.sendMessage("/003/ "+ "content" );
                break; //send friend request
            case "/004/": 
                break; //accept friend request
            case "/005/": 
                break; //decline friend request
            case "/006/":
                System.out.println("SHOULD NOT GET HERE: Accepted Friend Request");
                break;//Accepted Friend Request
            case "/007":
                break;
        }    
    }
    
    @Override
    public void ProccessInput(String message){
        user = User.getInstance();
        messanger = Messanger.getInstance();
        String[] spliceCommandCode = message.split(" ");
        String commandCode = spliceCommandCode[0];
        switch(commandCode){
            case "/000/": 
            break; //message person
            case "/001/": 
            break; //find person
            case "/002/": 
            break; //person found
            case "/003/": 
            break; //send friend request
            case "/004/": 
            break; //accept friend request
            case "/005/": 
            break; //decline friend request 
            case "/006/":
                //ADD USER TO FRIENDSLIST
                break;//Accepted Friend Request
            case "/007":
                break;
        }        
    }
}
