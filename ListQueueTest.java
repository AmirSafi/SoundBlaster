import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

public class ListQueueTest {

	  private ListQueue queue1;
	  private final static double EPSILON = 0.000000001;

	  /* testing constructor, normal processing*/
	  @Before
	  public void testConstructor(){
	    queue1 = new ListQueue();
	  }
	  
	  /* testing method size(), normal processing */

	@Test 
	  public void testSizeMethodNorm1() throws StackOverflowError{
	    queue1.enqueue(3.1);
	    queue1.enqueue(-42.32);
	    assertEquals(queue1.size(),2);
	  }
	  
	   /* testing method size(), normal processing */
	  @Test 
	  public void testSizeMethodNorm2() throws StackOverflowError{
	    queue1.enqueue(-1.3);
	    queue1.enqueue(88372.4324);
	    queue1.enqueue(0.00000032432);
	    queue1.enqueue(99);
	    queue1.enqueue(0);
	    queue1.enqueue(-1.4);
	    queue1.enqueue(8.9);
	    assertEquals(queue1.size(),7);
	  }
	  

	 

	  /* testing method size(), normal processing */
	  @Test 
	  public void testSizeMethodAfterdequeue() throws StackOverflowError , EmptyStackException{
	    queue1.enqueue(1.777);
	    queue1.enqueue(-2.333);
	    queue1.enqueue(0.0000423);
	    queue1.dequeue();
	    queue1.dequeue();
	    assertEquals(queue1.size(),1);
	  }  
	  
	  /* testing methods enqueue and dequeue, normal processing*/

	@Test 
	  public void testenqueueAnddequeue() throws StackOverflowError , EmptyStackException{
	     queue1.enqueue(0.0009523);
	     assertEquals(queue1.dequeue(),0.0009523, EPSILON);
	  }
	  
	  /* testing methods enqueue twice and then dequeue, normal processing*/
	@Test 
	  public void testenqueue2Anddequeue() throws StackOverflowError , EmptyStackException{
	     queue1.enqueue(-124.323);
	     queue1.enqueue(7.3);
	     assertEquals(queue1.dequeue(),-124.323 , EPSILON);
	  } 
	  
	  /* testing methods enqueue and then dequeue twice, error*/
	  @Test (expected = EmptyQueueException.class)
	  public void testenqueueAnddequeue2() throws StackOverflowError , EmptyStackException{
	     queue1.enqueue(15);
	     queue1.dequeue();
	     queue1.dequeue();
	  }
	  
	   /* testing methods dequeue on empty stack, error*/
	  @Test (expected = EmptyQueueException.class)
	  public void testdequeueEmptyStack() throws StackOverflowError , EmptyQueueException{
	     queue1.dequeue();
	  }
	  
	  /* testing methods enqueue and then peek, normal processing*/
	@Test 
	  public void testenqueueAndPeek() throws StackOverflowError , EmptyQueueException{
	     queue1.enqueue(3.333333);
	     assertEquals(queue1.peek(), 3.333333 , EPSILON);
	  }
	 
	  /* testing methods enqueue twice and then peek, normal processing*/
	@Test 
	  public void testenqueue2AndPeek() throws StackOverflowError , EmptyStackException{
	     queue1.enqueue(6.4);
	     queue1.enqueue(1.1);
	     assertEquals(queue1.peek(), 6.4, EPSILON);
	  }   
	  /* testing methods enqueue and then peek twice, normal processing*/
	@Test 
	  public void testenqueueAndPeek2() throws StackOverflowError , EmptyStackException{
	     queue1.enqueue(33.3);
	     queue1.peek();
	     assertEquals(queue1.peek(), 33.3, EPSILON);
	  }  
	  
	  /* testing methods peek on empty stack, error*/
	  @Test (expected = EmptyQueueException.class)
	  public void testPeekEmptyStack() throws StackOverflowError , EmptyStackException{
	     queue1.peek();
	  } 
	  
	  
}
