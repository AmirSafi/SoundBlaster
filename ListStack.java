import java.util.EmptyStackException;

/**
 * Implementation of linked list stack. Used an linked list as the
 * underlying data structure.
 * 
 * @author Amir Ali
 * @version CSE 373 17su, HW1:SoundBlaster,  6/24/2017 
 */
public class ListStack implements DStack {
	
 //keeps track of the number of objects in the linked list
 private int numElems = 0;
 //Variable to keep track of nodes at top of stack
 private Node top;

 /**
  * Constructor for ListStack
  * Time Complexity = (Big) O(k) - constant time 
  * 
  */
 public ListStack() {} //end constructor
 /**
  * Method to to check if the  ListStack is empty
  * Time Complexity = (Big) O(k) - constant time 
  *
  * @return Boolean Returns true if the array stack is empty and false otherwise
  */
 public boolean isEmpty() {
   return numElems == 0;
  } //end method isEmpty

 /**
  * Method to push objects to the top of the ListStack
  * Time Complexity = (Big) O(k) - constant time 
  *
  * @param d Double to be added to the  ListStack
  */
 public void push(double d) {
   //create Node that points to the top of the stack 
   //and also contains the JAVA double number
   Node currentNode = new Node(d, top);
   //update top reference to point top of stack
   top = currentNode;
   //after object is added increment numElems by 1
   numElems++;
  } //end method push

 /**
  * Method to pop(remove) objects from the ListStack
  * The order in which elements are removed from 
  * a stack is last in first out (LIFO)
  * Precondition: numElems > 0
  * Time Complexity = (Big) O(k) - constant time 
  *
  * @return Object The popped object
  * @throws EmptyStackException Exception thrown if the ListStack is empty
  */
 public double pop() {
   //precondition check
   if (numElems == 0) {
    throw new EmptyStackException();
   }
   //get object from node that is at the top of the stack
   double popped = top.data;
   //remove the top node
   top = top.next;
   //adjust number of elements in linked list array
   numElems--;
   return popped;
  } //end method pop

 /**
  * Method to peek and retrieve the last element in the ListStack.
  * Doesn't remove the element
  * Precondition: numElems > 0
  * Time Complexity = (Big) O(k) - constant time 
  *
  * @return Object Returns the last object in the stack
  * @throws EmptyStackException Throws exception if ListStack is empty
  */
 public double peek() {
   //precondition check
   if (numElems == 0) {
    throw new EmptyStackException();
   }
   return top.data;
  } //end method peek

 /**
  * Method to inquire about the size(number of elements) of the ListStack
  * Time Complexity = (Big) O(k) - constant time 
  *
  * @return Integer Returns the size of the ListStack
  */
 public int size() {
   return numElems;
  } //end method size
  /**
   * Helper inner class used for implementation 
   * of linked list. Objects of this class 
   * store JAVA double number type and a reference to the next Node.
   *
   */
 private class Node {
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
  public Node(double data, Node next) {
    this.data = data;
    this.next = next;
   } //end constructor 
 } //end class Node


} //end class ListStack