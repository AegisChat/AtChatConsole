/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atchat;

import java.util.ArrayList;
import java.util.UUID;
/**
 *
 * @author Avi
 */
public class Friend implements Cloneable{
    
    private UUID ID;
    private int clearance_level;
    private String name;
    private int location;
    private ArrayList<String> tags;
    private ArrayList<Conversation> conversation;
    private int gender;
    
    public Friend(String friend_name, UUID friend_id, int friend_clearance_level, ArrayList<String> tags){
        name = friend_name;
        ID = friend_id;
        clearance_level = friend_clearance_level;
        this.tags = (ArrayList<String>)tags.clone();
    }
    
    
    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }
    public void setGender(){
    this.gender=gender;
    }
    public int getGender(){
    return gender;
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
    
    public String tagsToString(){
        String ans = "";
        for(String tag: tags){
            ans = ans + tag + " ";
        }
        ans = ans.trim();
        return ans;
    }
    
    @Override
    public String toString(){//Convert friend bio into string
        String contactBio = null;
        contactBio = "&"+getName()+"& "+"@"+ID.toString()+"@ "+"%"+getGender()+"% "+"!"+tagsToString()+"!";
        return contactBio;        
    }
    
    public String simpleToString(){
        return getName() + " " + ID.toString();
    }
}
