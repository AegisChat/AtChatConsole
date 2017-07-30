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
    private User user = User.getInstance();
    
    public String ProccessOutput(String command, String message){
        String output = null;
        return output;
    }
    
    @Override
    public void ProccessInput(String message){
        
    }
}
