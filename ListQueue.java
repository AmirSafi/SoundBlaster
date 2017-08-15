import java.util.EmptyStackException;

/**
/**
  * Implementation of linked list queue. Used an linked list as the
  * underlying data structure.
  * 
  * @author Amir Ali
  * @version CSE 373 17su, HW1:SoundBlaster,  6/24/2017 
  */
public class ListQueue implements DQueue {
  //keeps track of the number of elements in the linked list queue 
  private int numElems = 0;
  //first node in queue
  private Node first;
  //last node in queue
  private Node last;
  
  /**
   * Constructor for LinkedListQueue
   * Time Complexity = (Big) O(k) = constant time 
   */
  public ListQueue(){}//end constructor  
  
  
	/**
	 * Method to check if the queue is empty
	 * 
	 * @return Boolean Returns true is the queue is empty and false otherwise 
	 */
	public boolean isEmpty() {
		return numElems == 0;
	}//end method isEmpty

	/**
	 * Method to add(enqueue) objects to the linked list queue
	 *
	 * Time Complexity = (Big) O(k) = constant time 
	 * 
	 * @param d JAVA double number to be added to the linked list queue 
	 */
	public void enqueue(double d) {
		// create a Node and add to back of the queue 
		Node lastIn = new Node(d,null);
		//if the queue is empty set first element 
		if(first == null){
			first = lastIn;
			last = lastIn;
		}else{
			last.next = lastIn;
		}
		//after object is added increment numElems by 1 
		numElems++;
	}//end method enqueue

	/**
	 * Method to remove(dequeue) objects from the linked list queue 
	 * The order in which elements are removed from queue is first in first out (FIFO)
	 * Precondition: numElems > 0
	 * Time complexity = (Big) O(k) = constant time 
	 * 
	 * @return double JAVA double number that is removed from the queue 
	 */
	public double dequeue() throws EmptyQueueException{
		//precondition check
		if(numElems == 0){
			throw new EmptyQueueException();
		}
		//get data from first node in the queue 
		double popped = first.data;
		//remove the top node 
		first = first.next;
		//adjust number of elements in the linked list array 
		numElems--;
		return popped;
	}//end method dequeue

 /**
  * Method to inquire about the size(number of elements) of the ListQueue. 
  * Time Complexity = (Big) O(k) = constant time 
  *
  * @return Integer Returns the size of the ListQueue
  */
	public int size() {
		return numElems;
	}//end method size

 /**
  * Method to peek and retrieve the last element in the ListQueue.
  * Doesn't remove the element
  * Precondition: numElems > 0
  * Time Complexity = (Big) O(k) = constant time 
  *
  * @return double Returns JAVA double number without removing it 
  * @throws EmptyQueueException Throws exception if ListQueue is empty
  */
	public double peek() {
	 //precondition check
	 if (numElems == 0) {
	  throw new EmptyQueueException();
	 }
	return first.data;
	}//end method peek 
	
    /**
   * Helper inner class used for implementation 
   * of linked list. Objects of this class 
   * store data(JAVA double numbers) and a reference to next Node.
   *
   */
  private class Node{
    //data stored in node
    double data;
    //reference to next Node
    Node next; 
    /**
     * Constructor for Node of linked list 
     * Takes data and reference to next Node
     * Time Complexity = (Big) O(k) - constant time 
     * 
     * @param data The data stored in the node
     * @param next Reference to the next node 
     */
    public Node(double data , Node next){
      this.data = data;
      this.next = next;
    }//end constructor 
  }//end class Node	

}//end class ListQueue 
