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
public class Main {
    
    public static void main(String[] args) {
        BinaryNode root=new BinaryNode(4);
        BinaryNode nodo1=new BinaryNode(1);
        BinaryNode nodo2=new BinaryNode(2);
        BinaryNode nodo3=new BinaryNode(3);
        //BinaryNode nodo4=new BinaryNode(4);
        BinaryNode nodo5=new BinaryNode(5);
        BinaryNode nodo6=new BinaryNode(6);
        BinaryNode nodo7=new BinaryNode(7);
        BinaryNode nodo8=new BinaryNode(8);
        root.LC=nodo2;
        root.RC=nodo5;
        nodo2.LC=nodo1;
        nodo2.RC=nodo3;
        nodo5.RC=nodo7;
        nodo7.LC=nodo6;
        nodo7.RC=nodo8;
        root.preorderTraversal();
        System.out.println();
        root.inorderTraversal();
        System.out.println();
        root.postorderTraversal();
        System.out.println();
        
        
    }        
    
}