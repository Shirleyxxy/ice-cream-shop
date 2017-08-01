/**
 * StackLL uses an instance of the LinkedList class to maintain the data.
 * 
 * @author Xueying Xu (Shirley)
 * @version Assignment 5
 * @param <T>
 */
public class StackLL<T> implements Stack<T> {
    
	private LinkedList<T> listStack;
	
	/**
	 * Constructs an empty linked list.
	 */
	public StackLL() {
		
		listStack = new LinkedList<T>();
		
	}
	
	/**
	 * Pushes an element onto the top of the stack.
	 * @param the pushed data
	 */
	public void push(T data) {
		
		listStack.insertFirst(data);
		
	}
	
	/**
	 * Removes the top of the stack and returns it.
	 * @return the popped data
	 */
	public T pop() {
		
		T data = listStack.getFirst();
		
		listStack.deleteFirst();
		
		return data;
				
	}
	
	/** 
	 * Gets the element at the top of the stack without removing it.
	 * @return the peeked data
	 */
	public T peek() {
		
		return listStack.getFirst();
	
	}
	
	/** 
	 * Tests if the stack is empty.
	 * @return true iff the stack is empty
	 */
	public boolean isEmpty() {
		
		return listStack.isEmpty();
		
	}
	
	/** 
	 * Returns a String representation of the stack.
	 * @return stack as String
	 */
	public String toString() {
		
		return listStack.toString();
	
	}
	
	
	
	
}
