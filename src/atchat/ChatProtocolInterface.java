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
public interface ChatProtocolInterface {
    public abstract void ProccessInput(String message);
    public abstract String ProccessOutput(String command, String message);   
}
