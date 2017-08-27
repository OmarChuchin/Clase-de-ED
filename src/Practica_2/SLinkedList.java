

package Practica_2;

import java.util.NoSuchElementException;


public class SLinkedList<E> implements List<E> {
	private SNode<E> top;
	private int size;
	
	public SLinkedList() {
		top = new SNode<E>();
		size = 0;
	}

	@Override
	public void addFirst(E e) {
                SNode<E> n=new SNode(e);
		if(this.isEmpty()){
                    n.next=this.top.next;
                    this.top.next=n;
                }
                else{
                    this.top.next=n;
                    n.next=null;}
                this.size++;
	}

	@Override
	public void addLast(E e) {
		SNode<E> n=new SNode(e);
                SNode<E> current=this.top.next;
                if(this.isEmpty())
                    this.addFirst(e);
                else{
                    while(current.next!=null)
                        current=current.next;
                current.next=n;
                n.next=null;
                }
                this.size++;}

	@Override
	public void add(int index, E element) {
            if(index<0 || index>=this.size)
                throw new IndexOutOfBoundsException();
            if(index==0)
                this.addFirst(element);
            else{
                int in=0;
                SNode<E> n=new SNode(element),
                        bef=this.top.next;
                while(in<index){
                    in++;
                    bef=bef.next;
                }
                n.next=bef.next;
                bef.next=n;
            }
            this.size++;
	}

	@Override
	public E removeFirst() {
                if(this.isEmpty())
                    throw new NoSuchElementException();
                this.size--;
                SNode<E> current=this.top.next;
                this.top.next=current.next;
                current.next=null;
                return current.value;
	}

	@Override
	public E removeLast() {
                if(this.isEmpty())
                    throw new NoSuchElementException();
                this.size--;
                SNode<E> current=this.top.next,
                    last=current.next;
                while(last.next!=null){
                    current=current.next;
                    last=last.next;
                }
                current.next=null;
                return last.value;
                
	}

	@Override
	public E remove(int index) {
            if(index>=this.size|| index<0)
                throw new IndexOutOfBoundsException();
            if(index==0){
                this.removeFirst();
            }
            SNode<E> current=this.top.next;
            int in=0;
            while(in<index-1){
                current=current.next;
                in++;
            }
            SNode<E> last=current.next;
            current.next=last.next;
            last.next=null;
            return last.value;
            
        }

	@Override
	public boolean remove(Object o) {
		SNode<E> current=this.top.next;
                int index=0;
                while(current.next!=null){
                    if(current.value.equals(o)){
                        this.remove(index);
                        return true;
                    }
                    index++;
                }
                if(current.value.equals(o)){
                    this.removeLast();
                    return true;
                }
                return false;
	}

	@Override
	public E getFirst() {
	if(this.isEmpty())
            throw new NoSuchElementException();
        return this.top.next.value;
	}

	@Override
	public E getLast() {
            if(this.isEmpty())
                throw new NoSuchElementException();
            SNode<E> value=this.top.next;
            while(value.next!=null)
                value=value.next;
            return value.value;
	}

	@Override
	public E get(int index) {
            
            return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object o) {
            int index=0;
            SNode<E> current=this.top.next;
            while(current.equals(o)==false){
                index++;
                current=current.next;}
            return index;
	}

	@Override
	public void clear() {
            this.top.next=null;
	}

	@Override
	public int size() {
            return this.size;
	}

	@Override
	public boolean isEmpty() {
            return this.top.next==null;
        }

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
        @Override
	public String toString() {
            if(this.isEmpty())
                return "[]";
            String str="[";
            SNode<E> current=this.top.next;
            boolean first=true;
            while(current.next!=null){
                if(first){
                    str+=String.valueOf(current.value) +", ";
                    first=false;}
                else
                    str+=", "+String.valueOf(current.value);
            }
            str+="]";
            return str;
	}
}
