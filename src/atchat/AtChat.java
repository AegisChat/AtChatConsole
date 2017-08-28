/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atchat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
/**
 *
 * @author Avi
 */
public class AtChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            File friends_list_file = new File("friends_list.txt");
            File blocked_list_file = new File("blocked_list.txt");
            if(friends_list_file.createNewFile()){
                System.out.println("Friends list file has been created");
            }else{
                System.out.println("Friends list file already exit");
            }
            if(blocked_list_file.createNewFile()){
                System.out.println("Blocked list file has been created");
            }else{
                System.out.println("Blocked list file already exit");
            }
            
        User n = User.getInstance();
        User_Text_Message m = new User_Text_Message("Hello", n.getID());
        m.displayTime();
        ArrayList<String> tags = new ArrayList<String>();
        tags.add("food");
        //n.addFriend("Rem", UUID.randomUUID(), 0, tags);
        //n.addFriend("Ram", UUID.randomUUID(), 0, tags);
        //n.removeFromFriendsList(UUID.fromString("2f34628e-427b-4245-b18c-09ef36d56564"));
        System.out.println(n.searchFriendsList(UUID.fromString("d32b6748-bf75-41f9-af59-904386fba72d")).simpleToString());
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
}   

    /*TO-DO:
User:
        - Add a friend to the friends list
        - Send a friend request
        - Have friend request accepted
        - Accept a friend request
Network: 
        - Recieve all information about the person
        - Fix ChatProtoocl
        - Connect to a server
        - Send messages to friends
        - Recieve all the information about the user

    */
/*
        System.out.println(goo.toString());
        if(n.checkFriendsList(id))
            System.out.println("Friend Found");
        System.out.println("Friends list");
        for(Friend f : foo)
            System.out.println(f.simpleToString());
        System.out.println("Removing ID 123 from friends_list");
        n.removeFromFriendsList(id);
        foo = n.getContactList();
        for(Friend f : foo)
            System.out.println(f.simpleToString());
*/