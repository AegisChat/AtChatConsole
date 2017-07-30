/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atchat;

import java.util.ArrayList;

/**
 *
 * @author Avi
 */
public class Friend implements Cloneable{
    
    private ID ID;
    private int clearance_level;
    private String name;
    private int location;
    private ArrayList<String> tags;
    private ArrayList<Conversation> conversation;

    public Friend(String friend_name, ID friend_id, int friend_clearance_level, ArrayList<String> tags){
        name = friend_name;
        ID = friend_id;
        clearance_level = friend_clearance_level;
        this.tags = tags;
    }
    public ID getID() {
        return ID.clone();
    }

    public void setID(int ID) {
        this.ID = new ID(ID);
    }

    public int getClearance_level() {
        return clearance_level;
    }

    public void setClearance_level(int clearance_level) {
        this.clearance_level = clearance_level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<Conversation> getConversation() {
        return conversation;
    }

    public void setConversation(ArrayList<Conversation> conversation) {
        this.conversation = conversation;
    }
    
    public Friend clone(){
        Friend friend = new Friend(getName(), getID(), clearance_level, getTags());
        return friend;
    }
    
}
