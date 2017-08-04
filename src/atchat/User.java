/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atchat;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Avi
 */
public class User {
    private ID ID;
    private String name;
    private int gender;
    private int location;
    private ArrayList<String> tags;
    private ArrayList<Friend> contact_list;
    private ArrayList<ID> blocked_list;
    private File friends_list_file;
    private File blocked_list_file;
    private FileReader friends_list_file_reader;
    private FileReader blocked_list_file_reader;
    private static User instance = null;
    
    private User(){
        ID = new ID(0); //TEMPORARY
        name = "";
        gender = 1;
        location = 100;
        tags = new ArrayList<String>();
        contact_list = new ArrayList<Friend>();
        blocked_list = new ArrayList<ID>();
        friends_list_file = new File("friends_list.txt");
        blocked_list_file = new File("blocked_list.txt");
        try {
            friends_list_file_reader = new FileReader(friends_list_file);
            blocked_list_file_reader = new FileReader(blocked_list_file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        retrieveFriendsList();
        retrieveBlockedList();
    }

    public static User getInstance() {
        if(instance == null) {
            instance = new User();
        }
        return instance;
    }
    
    private void retrieveFriendsList(){ 
        BufferedReader br  = new BufferedReader(friends_list_file_reader);
        String line = null;
        String friend_name = null;
        int friend_id;
        int friend_clearance_level;
        ArrayList<String> tags;
        try {
            while ((line = br.readLine())!=null) {
                    if(!line.equals(System.lineSeparator())){
                    System.out.println("Line is: "+ line);
                    friend_name = spliceName("Line Shows: "+line);
                    friend_id = spliceID(line);
                    friend_clearance_level = spliceClearanceLevel(line);
                    tags = this.spliceTags(line);
                    contact_list.add(new Friend(friend_name, new ID(friend_id), friend_clearance_level, tags));
                }
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    private void retrieveBlockedList(){
        BufferedReader br = new BufferedReader(blocked_list_file_reader);
            String line = null;
            try {
                while ((line = br.readLine())!=null) {
                    if(!line.equals(System.lineSeparator()))
                        blocked_list.add(new ID(spliceID(line)));
                }
                System.out.println("Blocked List: "+blocked_list.toString());
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    private String spliceName(String friendLine){
        String[] name = friendLine.split("&");
        //System.out.println("Friend Name: "+name[1]);        
        return name[1];
    }
    
    private int spliceID(String friendLine){
        String[] id = friendLine.split("@");
        //System.out.println("ID: "+ Integer.parseInt(id[1]));
        return Integer.parseInt(id[1]);
    }
    
    private int spliceClearanceLevel(String friendLine){
        String[] clearance = friendLine.split("%");
        //System.out.println("Friend Clearance Level: "+ Integer.parseInt(clearance[1]));
        return Integer.parseInt(clearance[1]);
    }
    
    private ArrayList<String> spliceTags(String friendLine){
        String[] split = friendLine.split("!");
        String[] tagz = split[1].split(" ");
        ArrayList<String> tags = new ArrayList<String>();
        for(String tag : tagz){
            tags.add(tag);
        }
        //System.out.println("Friend Tags: "+ tags.toString());
        return (ArrayList<String>)tags.clone();
    }
    
//  Returns false if id is not on friends list
    public boolean checkFriendsList(ID id){
        boolean friendFound = false;
        for(Friend friend : contact_list){
            if(friend.getID().getIDNumber() == id.getIDNumber());
            friendFound = true;
            break;
        }
        return friendFound;
    }

//  Returns false if id is not on blocked list    
    public boolean checkBlockedList(ID id){
        boolean blockedFound = false;
        for(ID blocked_id : blocked_list){
            if(blocked_id.equals(id.getIDNumber()));
            blockedFound = true;
            break;
        }
        return blockedFound;
    }
    
    public void sendFriendRequest(ID id){
        if(!checkFriendsList(id))
            System.out.println("Friend Request sent");
    }
    
    public void acceptFriendRequest(){    
    }
    
    //Check all methods inside for completion.
    public void blockContact(ID blocked_request_id){
        if(!checkBlockedList(blocked_request_id)){
            this.removeFromFriendsList(blocked_request_id);
            this.addToBlockedList(blocked_request_id);
            this.updateContactList();
            this.updateBlockedList();
        }else
            System.err.println("User is already blocked");
    }
    
    public void addToBlockedList(ID id){
        if(checkFriendsList(id)){
           contact_list.remove(this.searchFriendsList(id)); //WRONG //If the friend does exist then it removes from from contact list as well as blocks them.
           blocked_list.add(id);
           //System.out.println(" in friends list");
           updateContactList();//update the contact list file
        }
        else{
            blocked_list.add(id);//If friend doesn't exist within friends list then we just block the ID
            //System.out.println("not in friends list");
        }
           //updateBlockedList();//update the blocked list
    }
    
    public void updateBlockedList(){ //method for updating the blocked list   
        String blockedString = "";

        for (atchat.ID friend : blocked_list)
        blockedString = blockedString + friend.toString() + System.lineSeparator();

        PrintWriter printWriter = null;
            try {
                printWriter = new PrintWriter("friends_list.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        printWriter.print(blockedString);
        printWriter.flush();
        printWriter.close();
    }
  
    public void updateContactList(){//method for updating the contact list
        //System.out.println("updateContactList started");
        String contactString = "";

        for (Friend friend : contact_list)
            contactString = contactString + friend.toString() + System.lineSeparator();

        System.out.println(contactString);
        PrintWriter printWriter = null;
            try {
                printWriter = new PrintWriter("friends_list.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        printWriter.print(contactString);  
        printWriter.flush();
        printWriter.close();
    } 
    
    public void removeFromFriendsList(ID id){
        Friend temp; 
        temp = searchFriendsList(id);
        contact_list.remove(temp);
    }
    
    public Friend searchFriendsList(ID id){
        Friend foundFriend=null;
            for(Friend f : contact_list){
                if(f.getID().equals(id))
                    foundFriend = f;
            }
        return foundFriend;
    }
    
    public ID getID() {
        return ID;
    }

    public void setID(ID ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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
        this.tags = (ArrayList<String>)tags.clone();
    }

    public ArrayList<Friend> getContact_list() {
        return contact_list;
    }

    public void setContact_list(ArrayList<Friend> contact_list) {
        this.contact_list = contact_list;
    }

    public ArrayList<ID> getBlocked_list() {
        return blocked_list;
    }

    public void setBlocked_list(ArrayList<ID > blocked_list) {
        this.blocked_list = blocked_list;
    }
}
/*
        BufferedReader br  = new BufferedReader(friends_list_file_reader);
        String line = null;
        boolean friendFound = false;
        try {
            while ((line = br.readLine())!=null) {
                if(ID.equals(line)){
                   friendFound = true;
                   break;
                }
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return friendFound;
*/
