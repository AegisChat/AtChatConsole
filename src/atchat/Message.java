/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atchat;
import java.time.Instant;
/**
 *
 * @author Avi
 */
public abstract class Message {
    protected Instant time_created;
    protected String content;
    protected ID recipient;
    
    public Message(String message, ID recipient){
        time_created = Instant.now();
        content = message;
        this.recipient = recipient;
    }
    
    public void displayTime(){
        System.out.println(time_created.toString());
    }

    public Instant getMessage_created() {
        return time_created;
    }

    public void setMessageCreated(Instant time_created) {
        this.time_created = time_created;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
}
