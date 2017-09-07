
package Practica_3;


public class ArrayList<E> implements List<E> {
	public Object[] top;
	private int size;
	private final int initialCapacity = 5;
	private final int extraCapacity = 5;
	
	/**
	 * Creates a new ArrayList instance with the default initial capacity.
	 */
	public ArrayList() {
		this.top = new Object[initialCapacity];
		this.size = 0;
	}
	
	/**
	 * Increases the capacity of this ArrayList instance so that it 
	 * can hold at least extraCapacity elements more.
	 * This method allocates a new array with greater capacity than the
	 * current one (top.length + extraCapacity) and copies all elements
	 * from top to the newly allocated array. The reference top is then
	 * updated to point to the new array. 
	 * @param extraCapacity increase the capacity of this ArrayList by this amount
	 */
	private void reserveExtraCapacity(int extraCapacity) {
            Object[] res=new Object[this.top.length+extraCapacity];
            for(int i=0;i<this.size;i++)
                res[i]=this.top[i];
            this.top=res;
	}
	
	/**
	 * Increases the capacity of this list if its size equals the length of the array
	 * where the data is stored. This method calls reserveExtraCapacity when (size() >= top.length).
	 * reserveExtraCapacity is called using the instance variable extraCapacity.
	 */
	private void ensureCapacity() {
            if(this.top.length<=this.size())
                this.reserveExtraCapacity(extraCapacity);
	}
	
	/**
	 * Shifts elements in the array (top) to the right, starting at the given position.
	 * @param index the position in which the shift will begin
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
	 */
	private void shiftContentsRight(int index) {
            if(index<0||index>this.size())
                throw new IndexOutOfBoundsException();
            this.ensureCapacity();
            for(int i=this.size();i<index;i--){
                this.top[i]=this.top[i-1];
            }
            this.top[index]=null;
	}
	
	@Override
	public void addFirst(E e) {
            this.shiftContentsRight(0);
            this.top[0]=e;
            this.size++;
	}

	@Override
	public void addLast(E e) {
            this.ensureCapacity();
            this.top[this.size()]=e;
            this.size++;
	}

	@Override
	public void add(int index, E element) {
	}

	@Override
	public E getFirst() {
		return (E) this.top[0];
	}

	
	@Override
	public E getLast() {
		return (E) this.top[this.size-1];
	}

	
	@Override
	public E get(int index) {
            if(index<0||index>=this.size())
                throw new IndexOutOfBoundsException();
            return (E) this.top[index];
        }

	@Override
	public E set(int index, E element) {
            if(index<0||index>=this.size())
                throw new IndexOutOfBoundsException();
            E bef=this.get(index);
            this.top[index]=element;
            return bef;
            
        }

	@Override
	public void clear() {
            this.size=0;
            for(int i=0;i<this.size;i++)
                this.top[i]=null;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size()==0;
	}

	@Override
	public String toString() {
            if(this.isEmpty())
                return "[]";
            String result="["+String.valueOf(this.top[0]);
            for(int i=1;i<this.size();i++){
                result+=", "+String.valueOf(this.top[i]);
                System.out.println(i);}
            return result+"]";
	}
}
