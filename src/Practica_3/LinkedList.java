/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_3;

import java.util.NoSuchElementException;

/**
 *
 * @author omar
 */
public class LinkedList<E> implements List<E> {
    
    private Node<E> header;
    private int size;
    
    public LinkedList(){
        header=new Node<E>();
        size=0;
    }
    
    
    /**
     *Gets the node at the specified index. 
     * @param index the index of the node to get.
     * @return the node at the specified position
     * @throws IndexOutOfBoundsException() if the index is bigger than the list 
     */
    private Node<E> node(int index){
        if(index<0 || index>=this.size())
            throw new IndexOutOfBoundsException();
        Node<E> x;

        if(index<(this.size>>1)){
            //si pasa el elemento esta en la primera mitad de la lista
            x=header.next;
            for(int i=0;i<index;i++)
                x=x.next;
        }
        else{
            //si pasa, el elemento esta en la segunda mitad de la lista
            x=header.prev;
            for(int i=this.size;i>index;i--)
                x=x.prev;
        }
        return x;
    }
    
    
    
    //completado
    @Override
    public void addFirst(E e) {
        Node<E> n=new Node(e),head=this.header,F=this.header.next;
        n.next=F;
        n.prev=head;
        F.prev=n;
        head.next=n;
        this.size++;
    }

    
    
    //completado
    @Override
    public void addLast(E e) {
        Node<E> n=new Node(e),head=this.header,L=head.prev;
        n.next=head;n.prev=L;
        L.next=n;
        head.prev=n;
        this.size++;
    }

    
    //por probar
    @Override
    public void add(int index, E element) {
        if(index<0 || index>this.size())
            throw new IndexOutOfBoundsException("there is no said index");
        else if(index==0)
            this.addFirst(element);
        else if(index==this.size())
            this.addLast(element);
        else{
            Node<E> n=new Node(element),head=this.header;
            if(index<this.size()>>1){
                for(int i=0;i<index;i++)
                    head=head.next;
                Node<E> nex=head.next;
                n.prev=head;n.next=nex;
                head.next=n;
                nex.prev=n;
            }
            else{
                for(int i=this.size();i>index;i--)
                    head=head.prev;
                Node<E> Last=head.prev;
                n.prev=Last;n.next=head;
                Last.next=n;
                head.prev=n;
            }
            this.size++;
        }
        
    }

    @Override
    public E removeFirst() {
        if(this.isEmpty())
            throw new NoSuchElementException("the list is empty");
        Node<E> erase=this.header.next,save=erase.next;
        save.prev=this.header;
        erase.next=null;erase.prev=null;
        this.header=save;
        return erase.value;
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E getFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E getLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(Object o) {
        
    }

    
    //completado
    @Override
    public void clear() {
        this.size=0;
        this.header.next=null;this.header.prev=null;
    }

    
    //completado
    @Override
    public int size() {
        return this.size;
    }

    
    //completado
    @Override
    public boolean isEmpty() {
        if(this.header.next==null && this.header.prev==null)
            return true;
        return false;
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //completado
    @Override
    public String toString(){
        if(this.isEmpty())
            return "[]";
        Node<E> current=this.header.next;
        String val="["+String.valueOf(current.value);
        while(current.next!=this.header){
            current=current.next;
            val+=", "+String.valueOf(current.value);
        }
        return val+"]";
    }
}
