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
 public class SNode<T> {
	public T value;
	public SNode next;
	
	public SNode() {
		value = null;
		next = null;
	}
	
	public SNode(T value) {
		this.value = value;
		next = null;
	}
        
        
}

