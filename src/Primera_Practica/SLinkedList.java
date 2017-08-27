/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primera_Practica;

import java.util.NoSuchElementException;

/**
 *
 * @author omar
 */
public class SLinkedList<E> {
	private SNode<E> top;
	private int size;
	
	public SLinkedList() {
		top = new SNode<E>();
		size = 0;
	}
	
	public void addFirst(E e) {
		SNode<E> newNode = new SNode<E>(e);
		newNode.next = top.next;
		top.next = newNode;
		size++;
	}
        
        public void addLast(E e){
            SNode<E> current=this.top.next;
            while(current.next!=null)
                current=current.next;
            SNode<E> newNode= new SNode<E>(e);
            current.next=newNode;
            newNode.next=null;
            size++;
        }
        
        public void add(int index, E element){
            int in=0;
            SNode<E> last=top.next;
            SNode<E> forw=last.next;
            
            if(this.isEmpty())
                this.addFirst(element);
            else{
            while(in!=index){
                in++;
                last=last.next;
                forw=forw.next;}
            }
            
            
        }
        
        public E removeLast(){
            SNode<E> current=top.next;
            while (current.next!=null)
                current=current.next;
            current.next=null;
            return null;
        }
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
        @Override
	public String toString() {
		if(top.next == null)
			return "[]";
		
		SNode<E> current = top.next;
		String returnValue = "[" + current.value;
		while(current.next != null) {
			current = current.next;
			returnValue += ", " + current.value;
		}
		
		returnValue += "]";
		return returnValue;
	}
        
        public E getFirst(){
            if(this.isEmpty())
                throw new NoSuchElementException();
            SNode<E> current=this.top.next;
            return current.value;
            
        }
        
        public E getLast(){
            if (this.isEmpty())
                throw new NoSuchElementException();
            else{
                SNode<E> current =this.top.next;
                
                while(current.next!=null)
                    current=current.next;
                return current.value;
            }
                
        }
        
        public int IndexOf(Object e){
            int index=0;
            if(e==null){
                for(SNode <E> x=top.next; x!=null;x=x.next){
                    if(x.value == null)
                        return index;
                    index++;
                }
            }
            else{
                for(SNode<E> x=top.next; x!=null; x=x.next){
                    if(e.equals(x.value))
                        return index;
                index++;}
            }
            return -1;
                
        }
        
        
	
}
