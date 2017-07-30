/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atchat;

/**
 *
 * @author Avi
 */
public class ChatProtocol implements ChatProtocolInterface{
    
    public String ProccessOutput(String message){
        String output = null;
        String[] spliceCommandCode = message.split(" ");
        String commandCode = spliceCommandCode[0];
        switch(message){
            case "/000/": 
                break; //message person
            case "/001/": 
                break; //find person
            case "/002/": 
                break; //person found
            case "/003/": 
                output = message;
                break; //send friend request
            case "/004/": 
                break; //accept friend request
            case "/005/": 
                break; //decline friend request   
        }    
        return output;
    }
    
    @Override
    public void ProccessInput(String message){
        switch(message){
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
        }        
    }
    
    @Override
    public void sendFriendRequestProtocol(ID id){
        User user = User.getInstance();
        ProccessOutput("/003/ " + user.getID()+ " " +String.valueOf(id.getIDNumber()));
        System.out.println("/003/ " + user.getID().getIDNumber()+ " " +String.valueOf(id.getIDNumber()));
    }
}
