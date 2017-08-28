

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
                n.next=top.next;
                top.next=n;
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
		if(top.next == null) {
                    throw new NoSuchElementException();
		}
		SNode<E> current = top;
		while(current.next.next != null)
			current = current.next;
		
		SNode<E> nodeToRemove = current.next;
		current.next = null;
		size--;
		return nodeToRemove.value;
}

	@Override
	public E remove(int index) {
            if(index>=this.size|| index<0)
                throw new IndexOutOfBoundsException();
            if(index==0){
                this.removeFirst();
            }
            this.size--;
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
                        this.size--;
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
            if(index<0 || index>this.size())
                throw new IndexOutOfBoundsException();
            SNode<E> current=this.top.next;
            for(int i=0;i<index;i++)
                current=current.next;
            return current.value;
	}

	@Override
	public E set(int index, E element) {
            if(index<0 || index>this.size())
                throw new IndexOutOfBoundsException();
            SNode<E> current=this.top.next;
            for(int i=0;i<index;i++)
                current=current.next;
            //pero con este metodo solo se crea un apuntador
            //el regreso deberia ser tipo object no tipo E
            //para que de esta forma fuera posible hacer un clone()
            E prev=current.value;
            current.value=element;
            return prev;
	}

	@Override
	public boolean contains(E e) {
            int val=this.indexOf(e);
            if(val!=-1)
                return true;
            return false;
	}

	@Override
	public int indexOf(Object o) {
            int index=0;
            SNode<E> current=this.top.next;
            while(index<this.size()){
                if(current.value.equals(o))
                    return index;
                index++;
                current=current.next;}
            return -1;
	}

	@Override
	public void clear() {
            this.top.next=null;
            this.size=0;
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
            Object[] array=new Object[this.size()];
            if(this.isEmpty())
                return array;
            SNode<E> current=this.top.next;
            for(int i=0;i<this.size();i++){
                array[i]=current.value;
                current=current.next;
            }    
            return array;
	}
	
        @Override
	public String toString() {
            if(this.isEmpty())
                return "[]";
            String str="[";
            SNode<E> current=top.next;
            while(current.next!=null){
                str+=(String.valueOf(current.value)+", ");
                current=current.next;}
            str+=String.valueOf(current.value)+"]";
            return str;
	}
}
