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
        System.out.println("Testing: add(2 * i | i >= 0 && i < 10) + toString");
		System.out.println(iList);
		for(int i = 0; i < 10; i++) {
                    System.out.println(iList.isEmpty());
                    System.out.println(iList.size());
			iList.add(0, i * 2);
			System.out.println(iList);
		}
        System.out.println(iList);
		while(!iList.isEmpty()) {
                    System.out.println(iList.removeLast());
			System.out.println(iList);
		}
    }
    
}
