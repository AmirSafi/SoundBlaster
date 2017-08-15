/**
 * An interface containing abstract methods to be implemented 
 * by anyone that wants to be a queue 
 */ 
public interface DQueue {
/** 
 * is empty?
 */
public boolean isEmpty();

/**
 * Method to add objects to the queue 
 * 
 * @param d JAVA double number to be added to the queue 
 */
public void enqueue(double d);

/**
 * Method to remove objects from the queue 
 * @return double The removed JAVA double number
 * @throws EmptyStackException if queue is empty
 */
public double dequeue();

/**
 * Method to inquire about the size of a queue 
 * 
 * @return int Returns the size of the queue  
 */
public int size();

/**
 * Method to peek at the first element in the queue 
 * 
 * @throws EmptyStackException if queue is empty
 */
public double peek();
}//end interface DQueue 
