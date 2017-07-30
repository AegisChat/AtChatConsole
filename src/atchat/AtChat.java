/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atchat;

import java.io.File;
import java.io.IOException;

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
        
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}