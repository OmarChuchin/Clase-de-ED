/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_3;

import java.util.Random;


/**
 *
 * @author omar
 */
public class exer {
    public static boolean isPalindrome(String str){
        LinkedList<Character> word=new LinkedList();
        for(int i=0;i<str.length();i++){
            char letter=str.charAt(i);
            if(Character.isLetter(letter))
                word.addLast(Character.toLowerCase(letter));
        }
        while(word.size()>1){
            if(!word.getFirst().equals(word.getLast()))
                return false;
            word.removeFirst();word.removeLast();
        }
        return true;
    }
    
    public static String jumbleLetters(String str){
        LinkedList<Character> word=new LinkedList();
        Random rand=new Random();
        for (int i=0;i<str.length();i++){
            int z=rand.nextInt(2);
            if(z==0)
                word.addFirst(Character.toLowerCase(str.charAt(i)));
            else
                word.addLast(Character.toLowerCase(str.charAt(i)));
        }
        return word.palabra();
    }
    
    public static void main(String[] args) {
        System.out.println(jumbleLetters("Agustin"));
    }
    
}
