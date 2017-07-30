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
public class ID {
    private int id_number;
    
    public ID(int id_number){
        this.id_number = id_number; //TEMPORARY
    }
    public boolean equals(ID id){
        if (this.id_number == id.id_number)
            return true;
        else 
            return false;
    }
    
    public int getIDNumber(){
        return id_number;
    }
    
    public ID clone(){
        ID id = new ID(getIDNumber());
        return id;
    }
}

