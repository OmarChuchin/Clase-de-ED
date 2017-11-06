/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

/**
 *
 * @author omar
 */
public class BinaryNode {
    public BinaryNode LC,RC;
    public int value;
    
    public BinaryNode(int val){
        this.value=val;
        this.LC=null;
        this.RC=null;
    }
}
