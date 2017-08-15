import java.util.EmptyStackException;
/**
 * Implementation of array stack for JAVA double numbers. Uses an array as the
 * underlying data structure.The underlying array 
 * has an initial capacity which is doubled when the 
 * number of elements reaches capacity.
 *
 * @author Amir Ali
 * @version CSE 373 17su, HW1:SoundBlaster, 6/24/2017
 */
public class ArrayStack implements DStack {
 //the capacity of the underlying array 
 private int capacity;
 //keeps track of the array size
 private int numElems = 0;
 //array to hold the bounded array stack of objects
 private double[] elements;

 /**
  * Constructor for ArrayStack
  * Underlying array initial size = 10
  * Time Complexity = (Big) O(k) - constant time 
  */
 public ArrayStack() {
   //set the initial underlying array size to 10
   capacity = 10;
   elements = new double[capacity];
  } //end constructor


 /**
  * Method to to check if the array stack is empty
  * Time Complexity = (Big) O(k) - constant time 
  *
  * @return boolean Returns true if the array stack is empty and false otherwise
  */
 public boolean isEmpty() {
   return numElems == 0;
  } //end method isEmpty



 /**
  * Method to push JAVA double number to the top of the bounded stack
  * Precondition: numElems < capacity
  * Time Complexity = (Big) O(n) - linear
  *
  * @param d Double to be added to the ArrayStack
  * @throws StackOverflowException Exception if capacity of the stack reached before call to push
  */
 public void push(double d) {
   //If at capacity double the size of the underlying array
   //then copy all elements into new array.
   if (numElems == capacity) {
    //create new array with double the capacity
    capacity *= 2;
    double[] newArray = new double[capacity];
    //copy elements using for loop
    for (int i = 0; i < numElems; i++) {
     newArray[i] = elements[i];
    }
    //change the variable "elements" to point to "newArray" 
    elements = newArray;
   }
   //add object to the stack
   elements[numElems] = d;
   //update number of elements variable
   numElems++;
   //check if the array is 3/4 empty, if it is then it will use an array half the size 
   reSize();
  } //end method push



 /**
  * Method to pop(remove) JAVA double number from the bounded stack
  * The order in which elements are removed from 
  * a stack is last in first out (LIFO)
  * Precondition: numElems > 0
  * Time Complexity = (Big) O(k) - constant time 
  *
  * @return Double The popped JAVA double number
  * @throws EmptyStackException Exception thrown if the bounded stack is empty
  */
 public double pop() {
   //precondition check
   if (numElems == 0) {
    throw new EmptyStackException();
   }
   Double popped = elements[numElems - 1];
   //if an object is removed decrement numElems by 1.
   //Don't need to null out the object that was returned, since
   //numElems is adjusted, new added element will overwrite the object at this index.
   numElems--;
   //check if the array is 3/4 empty, if it is then it will use an array half the size 
   reSize();
   return popped;
  } //end method pop



 /**
  * Method to peek and retrieve the last element in the ArrayStack.
  * Doesn't remove the element
  * Precondition: numElems > 0
  * Time Complexity = (Big) O(k) - constant time 
  *
  * @return Double Returns the last JAVA double number in the stack
  * @throws EmptyStackException Throws exception if bounded stack is empty
  */
 public double peek() {
   //precondition check
   if (numElems == 0) {
    throw new EmptyStackException();
   }
   return elements[numElems - 1];
  } //end method Peek

 /**
  * Method to resize the array to half the size when the array is 3/4 empty.
  * Precondition: array is 3/4 empty
  * Time Complexity = (Big) O(n) - linear time 
  */
 public void reSize() {
   //If the array is 3/4 empty then resize the array to half the size 
   //do this by copying all elements into new array with half the size.
   if (numElems <= capacity / 4) {
    //create new array with double the capacity
    capacity /= 2;
    double[] newArray = new double[capacity];
    //copy over all elements
    for (int i = 0; i < numElems; i++) {
     newArray[i] = elements[i];
    }
    //change the variable "elements" to point to "newArray" 
    elements = newArray;
   }
  } //end method reSize

 /**
  * Method to inquire about the size(number of elements) of the ArrayStack
  * Time Complexity = (Big) O(k) - constant time 
  *
  * @return Integer Returns the size of the ArrayStack
  */
 public int size() {
   return numElems;
  } //end method size
 
 
 /**
  * Method to get the current capacity of the ArrayStack
  * 
  * @return int The current capacity of the ArrayStack
  */
 public int capacity() {
	 return capacity;
 }//end method capacity 

} //end class ArrayStack