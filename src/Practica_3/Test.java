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
public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> iList=new LinkedList();
        for(int i=1;i<11;i++)
            iList.addLast(i);
        System.out.println("iList");
        System.out.println(iList);
        System.out.println(iList.josephus(4));
        
    }
    
}
