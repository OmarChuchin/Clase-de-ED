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
     * Makes a copy of the LinkedList in the parameter
     * @param L list to copy
     */
    public LinkedList(LinkedList L){
        header=new Node<E>();
        size=0;
        for(int i=0;i<L.size();i++)
            this.addLast((E) L.get(i));
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

    
    //completado
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

    
    //completado
    @Override
    public E removeFirst() {
        if(this.isEmpty())
            throw new NoSuchElementException("the list is empty");
        Node<E> head=this.header,erase=head.next,save=erase.next;
        head.next=save;save.prev=head;
        erase.next=erase.prev=null;
        this.size--;
        return erase.value;
    }

    
    //completado
    @Override
    public E removeLast() {
        if(this.isEmpty())
            throw new NoSuchElementException("the list is empty");
        Node<E> head=this.header,erase=head.prev,save=erase.prev;
        save.next=head;head.prev=save;
        erase.next=erase.prev=null;
        this.size--;
        return erase.value;
    }

    
    //completado
    @Override
    public E remove(int index) {
        if(index<0)
            throw new IndexOutOfBoundsException("there is no said index");
        while(index>=this.size())
            index-=this.size();
        if(index==0)
            this.removeFirst();
        else{
            Node<E> head=this.header;
            if(index<this.size()>>1){
                for(int i=0;i<index;i++)
                    head=head.next;
                Node<E> erase=head.next,save=erase.next;
                head.next=save;save.prev=head;
                erase.next=erase.prev=null;
                this.size--;
                return erase.value;
            }
            else{
                for(int i=this.size();i>index;i--)
                    head=head.prev;
                Node<E> erase=head.prev,save=erase.prev;
                save.next=head;head.prev=save;
                erase.next=erase.prev=null;
                this.size--;
                return erase.value;
            }
        }
        return null;
    }

    
    //completado
    @Override
    public boolean remove(Object o) {
        if(this.isEmpty())
            return false;
        Node<E> top=this.header.next;
        int i=0;
        while(top.next!=this.header){
            if(top.value.equals(o)){
                this.remove(i);
                return true;
            }
            top=top.next;
            i++;
        }
        if(top.value.equals(o)){
            this.removeLast();
            return true;
        }
        return false;
    }

    
    //completado
    @Override
    public E getFirst() {
        if(this.isEmpty())
            throw new NoSuchElementException("the list is empty");
        return this.header.next.value;
    }

    
    //completado
    @Override
    public E getLast() {
        if(this.isEmpty())
            throw new NoSuchElementException("the list is empty");
        return this.header.prev.value;
    }

    
    //testing
    @Override
    public E get(int index) {
        if(index<0 || index>=this.size())
            throw new IndexOutOfBoundsException("the index is unreachable");
        Node<E> head=this.header.next;
        for(int i=0;i<index;i++)
            head=head.next;
        return head.value;
    }

    
    //completado
    @Override
    public E set(int index, E element) {
        if(index<0 || index>=this.size())
            throw new IndexOutOfBoundsException("it is unreachable");
        Node<E> head=this.header;
        if(index<(this.size()>>1)){
            head=head.next;
            for (int i=0;i<index;i++)
                head=head.next;
            E ret=head.value;
            head.value=element;
            return ret;
        }
        else{
            head=head.prev;
            for(int i=this.size();i>index;i--)
                head=head.prev;
            E ret=head.value;
            head.value=element;
            return ret;
        }
    }
    
    
    //completado
    @Override
    public boolean contains(E e) {
        if(this.isEmpty())
            return false;
        Node<E> head=this.header.next;
        while(head.next!=this.header){
            if(head.value.equals(e))
                return true;
            head=head.next;
        }
        return head.value.equals(e);
    }

    
    //completado
    @Override
    public int indexOf(Object o) {
        if(this.isEmpty())
            return -1;
        Node<E> head=this.header.next;
        int i=0;
        while(head.next!=this.header){
            if(head.value.equals(o))
                return i;
            head=head.next;i++;
        }
        if(head.value.equals(o))
            return this.size()-1;
        return -1;
    }

    
    //completado
    @Override
    public void clear() {
        this.size=0;
        this.header.next=this.header;this.header.prev=this.header;
    }

    
    //completado
    @Override
    public int size() {
        return this.size;
    }

    
    //completado
    @Override
    public boolean isEmpty() {
        return this.header.next==this.header;
    }

    
    //completado
    @Override
    public Object[] toArray() {
        Object[] ret=new Object[this.size()];
        if(this.isEmpty())
            return ret;
        Node<E> top=this.header.next;
        for(int i=0;i<this.size();i++){
            ret[i]=this.get(i);
            top=top.next;
        }
        return ret;
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
    
    public String palabra(){
        if(this.isEmpty())
            return "";
        Node<E> current=this.header.next;
        String val=String.valueOf(current.value);
        while(current.next!=this.header){
            current=current.next;
            val+=String.valueOf(current.value);
        }
        return val;
        
    }
    
    public String josephus(int pasos){
        if(this.isEmpty())
            return "[]";
        LinkedList<E> l=new LinkedList(this);
        int place=0;
        while (l.size()>1){
            for(int i=0;i<pasos;i++){
                if(place==l.size())
                    place=0;
                else    
                    place++;
            }
            System.out.println(l.get(place));
            l.remove(l.get(place));
            System.out.println(l);
        }
        return l.toString();
    }
}
