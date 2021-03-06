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
 */
public class User_Text_Message extends Message{
    private boolean viewed;
    private boolean delivered;
    private UUID recipient;
    
    public User_Text_Message(String message, UUID recipient){
        super(message, recipient);
        viewed = false;
        delivered = false;
    }
    
    public String createMessage(){
        return content;
    }

    public boolean isViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
    
}
