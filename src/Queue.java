
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author Neil Woodhouse 851182
 *
 */


import java.util.NoSuchElementException;

public class Queue<T> {

	private QueueElement<T>head;
	private QueueElement<T> tail;

	
	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
	    head = null;
		tail = null;
	}
	
	/**
	 * Returns true if the queue is empty
	 * @return true if the queue contains no elements, otherwise returns false
	 */
	public boolean isEmpty () {
	    if (head == null && tail == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	 * Returns the element at the head of the queue
	 * @return the element stored at the head of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T peek () throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Cannot read an element from an empty queue");
		}
		else {
			return head.getElement();
		}
	}
	
	/**
	 * Removes the front element of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public void dequeue () throws NoSuchElementException {
	    if (isEmpty()) {
	    	throw new NoSuchElementException("Cannot remove an element from an empty queue");
		}
		else {
			head = head.getNext();
			if (head == null) {
				tail = null;
			}
		}
	}
	
	/**
	 * Puts an element on the back of the queue.
	 * @param element the element to be added to the queue
	 */
	public void enqueue (T element) {
	    if (isEmpty()) {
	    	head = new QueueElement<T>(element, null);
	    	tail = head;
		}
	    else {
	    	QueueElement<T> newElement = new QueueElement<>(element, null);
	    	tail.setNext(newElement);
	    	tail = newElement;
		}
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
		if (isEmpty()) {
			System.out.println("The queue is empty.");
		}
		else {
			StringBuilder output = new StringBuilder();
			QueueElement<T> currentElement = head;
			while (currentElement != null) {
				output.append(currentElement.getElement().toString() + ",\n");
				currentElement = currentElement.getNext();
			}
			System.out.println(output);
		}
	}
}
