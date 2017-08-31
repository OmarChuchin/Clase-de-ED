/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_3;

/**
 *
 * @author omar
 */
public class Node<T> {
    public Node<T> prev,
            next;
    public T value;
    
    public Node(){
        value=null;
        prev=this;
        next=this;
    }
    
    public Node(T e){
        this.value=e;
        prev=this;
        next=this;
    }
}
