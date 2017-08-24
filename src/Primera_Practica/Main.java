/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primera_Practica;

/**
 *
 * @author omar
 */
 public class Main {
 
 	public static void main(String[] args) {
		System.out.println("Hola, Mundo!");
		/*IntegerLinkedList iList = new IntegerLinkedList();
		System.out.println(iList);
		iList.addFirst(5);
		System.out.println(iList);
		iList.addFirst(10);
		System.out.println(iList);
		iList.addLast(7);
		System.out.println(iList);*/
		
		SLinkedList<String> sList = new SLinkedList<String>();
		sList.addFirst("World");
		sList.addFirst("Hello");
		System.out.println(sList);
		
		SLinkedList<Integer> iList = new SLinkedList<Integer>();
		for(int i=0; i<10; i++)
			iList.addFirst(i);
		System.out.println(iList);
 	}
 	
 } 
