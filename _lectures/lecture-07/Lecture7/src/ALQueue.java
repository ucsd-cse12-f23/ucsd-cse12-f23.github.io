import java.util.ArrayList;

interface Queue<E> {
	void enqueue(E element);
	E dequeue();
	E peek();
	int size();
}

public class ALQueue<E> implements Queue<E>{
	ArrayList<E> contents;
	
	ALQueue() {
		this.contents = new ArrayList<E>();
	}
	
	@Override
	public void enqueue(E element) {
		this.contents.add(element);
	}
	
	public E dequeue() {
		
		E temp = this.contents.remove(0);
		//E temp2 = this.contents.get(0);
		return temp;
		
		//return this.contents.remove(0);
	}
	
	public E peek() {
		return this.contents.get(0);
	}
	
	public int size() {
		return this.contents.size();
	}
	
	@Override
	public String toString() {
		return "front -> " + this.contents.toString() + "<- back";
	}
}

