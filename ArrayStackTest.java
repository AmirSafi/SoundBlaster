import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;
import org.junit.*;

public class ArrayStackTest {
  private ArrayStack stack1;
  private final static double EPSILON = 0.000000001;

  /* testing constructor, normal processing*/
  @Before
  public void testConstructor(){
    stack1 = new ArrayStack();
  }
  
  /* testing method size(), normal processing */

@Test 
  public void testSizeMethodNorm1() throws StackOverflowError{
    stack1.push(3.1);
    stack1.push(-42.32);
    assertEquals(stack1.size(),2);
  }
  
   /* testing method size(), normal processing */
  @Test 
  public void testSizeMethodNorm2() throws StackOverflowError{
    stack1.push(-1.3);
    stack1.push(88372.4324);
    stack1.push(0.00000032432);
    stack1.push(99);
    stack1.push(0);
    stack1.push(-1.4);
    stack1.push(8.9);
    assertEquals(stack1.size(),7);
  }
  
  
  /* testing method size(), normal processing */
 @Test 
 public void testSizeMethodNorm3() throws StackOverflowError{
   stack1.push(-1.3);
   stack1.push(88372.4324);
   stack1.push(0.00000032432);
   stack1.push(99);
   stack1.push(0);
   stack1.push(-1.4);
   stack1.pop();
   stack1.pop();
   stack1.pop();
   stack1.pop();
   stack1.pop();
   stack1.push(882.424);
   stack1.push(2.24);
   assertEquals(stack1.capacity(),4);
 }
 
 
 /* testing method size(), normal processing */
@Test 
public void testSizeMethodNorm4() throws StackOverflowError{
  stack1.push(-1.3);
  stack1.push(88372.4324);
  stack1.push(0.00000032432);
  stack1.push(99);
  stack1.push(0);
  stack1.push(-1.4);
  stack1.pop();
  stack1.pop();
  stack1.pop();
  stack1.pop();
  stack1.pop();
  assertEquals(10/4,2);
}
  /* testing method size(), normal processing */
  @Test 
  public void testSizeMethodAfterPop() throws StackOverflowError , EmptyStackException{
    stack1.push(1.777);
    stack1.push(-2.333);
    stack1.push(0.0000423);
    stack1.pop();
    stack1.pop();
    assertEquals(stack1.size(),1);
  }  
  
  /* testing methods push and pop, normal processing*/

@Test 
  public void testPushAndPop() throws StackOverflowError , EmptyStackException{
     stack1.push(0.0009523);
     assertEquals(stack1.pop(),0.0009523, EPSILON);
  }
  
  /* testing methods push twice and then pop, normal processing*/
@Test 
  public void testPush2AndPop() throws StackOverflowError , EmptyStackException{
     stack1.push(-124.323);
     stack1.push(7.3);
     assertEquals(stack1.pop(),7.3 , EPSILON);
  } 
  
  /* testing methods push and then pop twice, error*/
  @Test (expected = EmptyStackException.class)
  public void testPushAndPop2() throws StackOverflowError , EmptyStackException{
     stack1.push(15);
     stack1.pop();
     stack1.pop();
  }
  
   /* testing methods pop on empty stack, error*/
  @Test (expected = EmptyStackException.class)
  public void testPopEmptyStack() throws StackOverflowError , EmptyStackException{
     stack1.pop();
  }
  
  /* testing methods push and then peek, normal processing*/
@Test 
  public void testPushAndPeek() throws StackOverflowError , EmptyStackException{
     stack1.push(3.333333);
     assertEquals(stack1.peek(), 3.333333 , EPSILON);
  }
 
  /* testing methods push twice and then peek, normal processing*/
@Test 
  public void testPush2AndPeek() throws StackOverflowError , EmptyStackException{
     stack1.push(6.4);
     stack1.push(1.1);
     assertEquals(stack1.peek(), 1.1, EPSILON);
  }   
  /* testing methods push and then peek twice, normal processing*/
@Test 
  public void testPushAndPeek2() throws StackOverflowError , EmptyStackException{
     stack1.push(33.3);
     stack1.peek();
     assertEquals(stack1.peek(), 33.3, EPSILON);
  }  
  
  /* testing methods peek on empty stack, error*/
  @Test (expected = EmptyStackException.class)
  public void testPeekEmptyStack() throws StackOverflowError , EmptyStackException{
     stack1.peek();
  } 
  
  
}
