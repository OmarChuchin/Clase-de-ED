package Practica_6;
public class Queue<E> implements IQueue<E> {
	private LinkedList<E> queue;
	
	public Queue() {
		queue = new LinkedList<E>();
	}

	@Override
	public void offer(E e) {
	    this.queue.addLast(e);
	}

	@Override
	public E remove() {
            return this.queue.removeFirst();
	}

	@Override
	public E element() {
            return this.queue.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return this.queue.isEmpty();
	}

	@Override
	public void clear() {
            this.queue.clear();
	}

	@Override
	public int size() {
            return this.queue.size();
	}

	@Override
	public Object[] toArray() {
            return this.queue.toArray();
        }

}
