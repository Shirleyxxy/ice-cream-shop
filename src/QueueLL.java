/**
 * QueueLL uses an instance of the LinkedList class to maintain the data.
 * 
 * @author Xueying Xu (Shirley)
 * @version Assignment 6
 * @param <T>
 */
public class QueueLL<T> implements Queue<T> {
    
	private LinkedList<T> listQueue;
	
	/**
	 * Constructs an empty linked list.
	 */
	public QueueLL() {
		
		listQueue = new LinkedList<T>();
		
	}
	
	/** 
	 * Gets the element at the front of the queue without removing it.
	 * @return the peeked data
	 */
	public T peek() {
		
		return listQueue.getFirst();
	}
	
	/**
	 * Removes the front element of the queue and returns it.
	 * @return the dequeued data
	 **/
	public T dequeue() {
		
		T data = listQueue.getFirst();
		
		listQueue.deleteFirst();
		
		return data;
		
	}
    
	/**
	 * Adds an element to the end of the queue.
	 * @param data the enqueued data
	 **/
	public void enqueue(T data) {
		
		listQueue.insertLast(data);
	
	}
	
	/** 
	 * Tests if the queue is empty.
	 * @return true iff the queue is empty
	 */
	public boolean isEmpty() {
		
		return listQueue.isEmpty();
		
	}
	
	/** 
	 * Returns a String representation of the queue.
	 * @return queue as String
	 */
	public String toString() {
		
		return listQueue.toString();
	
	}

}
